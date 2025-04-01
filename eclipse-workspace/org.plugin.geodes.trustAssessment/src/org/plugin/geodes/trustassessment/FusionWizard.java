package org.plugin.geodes.trustassessment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class FusionWizard extends Wizard {
    private TrustDSLFileSelectionPage trustdslPage;
    private ProvnFileSelectionPage provnPage;
    private ParameterAssignmentPage paramPage;

    private String trustdslFilePath;
    private String provnFilePath;
    private String agentName;
    private Map<String, double[]> parameterOpinions = new HashMap<>();

    public FusionWizard() {
        setWindowTitle("Fusion Wizard");
    }

    @Override
    public void addPages() {
        trustdslPage = new TrustDSLFileSelectionPage("TrustDSL File & Agent");
        addPage(trustdslPage);
        provnPage = new ProvnFileSelectionPage("PROVN File & Parameter Extraction");
        addPage(provnPage);
        paramPage = new ParameterAssignmentPage("Parameter Opinion Assignment");
        addPage(paramPage);
    }

    @Override
    public boolean performFinish() {
        trustdslFilePath = trustdslPage.getTrustdslFilePath();
        agentName = trustdslPage.getAgentName();
        provnFilePath = provnPage.getProvnFilePath();
        parameterOpinions = paramPage.getParameterOpinions();

        for (Map.Entry<String, double[]> entry : parameterOpinions.entrySet()) {
            double[] opinion = entry.getValue();
            double sum = opinion[0] + opinion[1] + opinion[2];
            if (Math.abs(sum - 1.0) > 0.0001) {
                MessageDialog.openError(getShell(), "Validation Error", "For parameter " 
                        + entry.getKey() + ", belief + disbelief + uncertainty must equal 1.");
                return false;
            }
        }

        try {
            String trustdslContent = new String(Files.readAllBytes(Paths.get(trustdslFilePath)), "UTF-8");
            
            if (!trustdslContent.matches("(?s).*\\bAgent\\s+" + Pattern.quote(agentName) + "\\b.*")) {
                trustdslContent = "Agent " + agentName + "\n" + trustdslContent;
            }

            for (Map.Entry<String, double[]> entry : parameterOpinions.entrySet()) {
                String param = entry.getKey();
                double[] opinion = entry.getValue();
                String beliefName = agentName + "_" + param;
                String beliefDeclaration = "Belief " + beliefName + " (" + agentName + ", (" 
                        + opinion[0] + ", " + opinion[1] + ", " + opinion[2] + ", " + opinion[3] + "))";
                Pattern uePattern = Pattern.compile("UncertainElement\\s+" + Pattern.quote(param) + "\\s*\\{", Pattern.DOTALL);
                Matcher ueMatcher = uePattern.matcher(trustdslContent);
                if (ueMatcher.find()) {
                    int ueStart = ueMatcher.start();
                    int beliefsIndex = trustdslContent.indexOf("beliefs {", ueStart);
                    if (beliefsIndex != -1) {
                        int blockEndIndex = trustdslContent.indexOf("}", beliefsIndex);
                        if (blockEndIndex != -1) {
                            String beliefsBlock = trustdslContent.substring(beliefsIndex, blockEndIndex);
                            String insertion;
                            if (beliefsBlock.contains("Belief")) {
                                insertion = "\n        , " + beliefDeclaration + "\n";
                            } else {
                                insertion = "\n        " + beliefDeclaration + "\n";
                            }
                            trustdslContent = trustdslContent.substring(0, blockEndIndex)
                                    + insertion
                                    + trustdslContent.substring(blockEndIndex);
                        }
                    }
                } else {
                    String newBlock = "\nUncertainElement " + param + " {\n" +
                            "    beliefs {\n" +
                            "        " + beliefDeclaration + "\n" +
                            "    }\n" +
                            "}\n";
                    trustdslContent += newBlock;
                }
            }


            Files.write(Paths.get(trustdslFilePath), trustdslContent.getBytes("UTF-8"), StandardOpenOption.WRITE);
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "File Error", "Error writing to TrustDSL file: " + e.getMessage());
            return false;
        }
        return true;
    }

    // --- TrustDSL File & Agent Selection Page ---
    class TrustDSLFileSelectionPage extends WizardPage {
        private Text filePathText;
        private Text agentNameText;

        protected TrustDSLFileSelectionPage(String pageName) {
            super(pageName);
            setTitle("Select TrustDSL File & Specify Agent");
            setDescription("Choose an existing .trustdsl file and enter a name for your agent.");
        }

        @Override
        public void createControl(Composite parent) {
            Composite container = new Composite(parent, SWT.NONE);
            container.setLayout(new GridLayout(3, false));

            Label fileLabel = new Label(container, SWT.NONE);
            fileLabel.setText("TrustDSL File:");
            filePathText = new Text(container, SWT.BORDER);
            filePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            Button browseButton = new Button(container, SWT.PUSH);
            browseButton.setText("Browse...");
            browseButton.addListener(SWT.Selection, event -> {
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setFilterExtensions(new String[] { "*.trustdsl" });
                String result = dialog.open();
                if (result != null) {
                    filePathText.setText(result);
                }
            });

            Label agentLabel = new Label(container, SWT.NONE);
            agentLabel.setText("Agent Name:");
            agentNameText = new Text(container, SWT.BORDER);
            agentNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            new Label(container, SWT.NONE);

            setControl(container);
        }

        public String getTrustdslFilePath() {
            return filePathText.getText().trim();
        }

        public String getAgentName() {
            return agentNameText.getText().trim();
        }
    }

    // --- PROVN File & Parameter Extraction Page ---
    class ProvnFileSelectionPage extends WizardPage {
        private Text filePathText;
        private List<String> parameterList = new ArrayList<>();
        private ListViewer listViewer;
        private Map<String, Double> parameterAPrioriMap = new HashMap<>();

        protected ProvnFileSelectionPage(String pageName) {
            super(pageName);
            setTitle("Select PROVN File");
            setDescription("Choose a .provn file. The wizard will scan it for parameters with a numeric value (e.g., value=\"0.101\").");
        }

        @Override
        public void createControl(Composite parent) {
            Composite container = new Composite(parent, SWT.NONE);
            container.setLayout(new GridLayout(3, false));

            Label fileLabel = new Label(container, SWT.NONE);
            fileLabel.setText("PROVN File:");
            filePathText = new Text(container, SWT.BORDER);
            filePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            Button browseButton = new Button(container, SWT.PUSH);
            browseButton.setText("Browse...");
            browseButton.addListener(SWT.Selection, event -> {
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setFilterExtensions(new String[] { "*.provn" });
                String result = dialog.open();
                if (result != null) {
                    filePathText.setText(result);
                    scanProvnFile(result);
                }
            });

            Label listLabel = new Label(container, SWT.NONE);
            listLabel.setText("Extracted Parameters:");
            GridData listLabelGD = new GridData(SWT.FILL, SWT.TOP, false, false, 3, 1);
            listLabel.setLayoutData(listLabelGD);

            listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
            listViewer.setContentProvider(ArrayContentProvider.getInstance());
            GridData listGD = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
            listViewer.getControl().setLayoutData(listGD);

            setControl(container);
        }

        private void scanProvnFile(String filePath) {
            parameterList.clear();
            parameterAPrioriMap.clear();
            try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                Pattern pattern = Pattern.compile("entity\\([^:]+:([^,\\)]+).*prov:value\\s*=\\s*\"([0-9]+(?:\\.[0-9]+)?)\"");
                for (String line : lines) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String paramName = matcher.group(1).trim();
                        String valueStr = matcher.group(2).trim();
                        if (!paramName.isEmpty() && !valueStr.isEmpty() && !parameterList.contains(paramName)) {
                            parameterList.add(paramName);
                            parameterAPrioriMap.put(paramName, Double.parseDouble(valueStr));
                        }
                    }
                }
                listViewer.setInput(parameterList);
                listViewer.refresh();
            } catch (IOException ex) {
                MessageDialog.openError(getShell(), "File Error", "Error reading PROVN file: " + ex.getMessage());
            }
        }

        public String getProvnFilePath() {
            return filePathText.getText().trim();
        }

        public List<String> getParameterList() {
            return parameterList;
        }

        public Map<String, Double> getParameterAPrioriMap() {
            return parameterAPrioriMap;
        }
    }

    // --- Parameter Opinion Assignment Page ---
    class ParameterAssignmentPage extends WizardPage {
        private Table table;
        private Map<String, double[]> parameterOpinions = new HashMap<>();

        protected ParameterAssignmentPage(String pageName) {
            super(pageName);
            setTitle("Assign Beliefs to Parameters");
            setDescription("For each parameter, assign a tuple (belief, disbelief, uncertainty, a-priori, scanned value). " +
                    "Note: belief + disbelief + uncertainty must equal 1.");
        }

        @Override
        public void createControl(Composite parent) {
            Composite container = new Composite(parent, SWT.NONE);
            container.setLayout(new GridLayout(2, false));

            Label instructions = new Label(container, SWT.WRAP);
            instructions.setText("Select a parameter (from the previous page) and click 'Add Assignment' to set its opinion.");
            instructions.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));

            table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
            table.setHeaderVisible(true);
            table.setLinesVisible(true);
            GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
            table.setLayoutData(tableData);
            TableColumn colParam = new TableColumn(table, SWT.NONE);
            colParam.setText("Parameter");
            colParam.setWidth(150);
            TableColumn colOpinion = new TableColumn(table, SWT.NONE);
            colOpinion.setText("Opinion (belief, disbelief, uncertainty, a-priori, scanned)");
            colOpinion.setWidth(350);

            Button addButton = new Button(container, SWT.PUSH);
            addButton.setText("Add Assignment");
            addButton.addListener(SWT.Selection, event -> {
                // Pass the parameter list and the a-priori mapping from the ProvnFileSelectionPage.
                ParameterAssignmentDialog dialog = new ParameterAssignmentDialog(getShell(), getParameterList(), provnPage.getParameterAPrioriMap());
                if (dialog.open() == Dialog.OK) {
                    String param = dialog.getSelectedParameter();
                    double[] values = dialog.getOpinionValues();
                    if (values != null) {
                        double sum = values[0] + values[1] + values[2];
                        if (Math.abs(sum - 1.0) > 0.0001) {
                            MessageDialog.openError(getShell(), "Validation Error", 
                                    "For parameter " + param + ", belief + disbelief + uncertainty must equal 1.");
                        } else if (parameterOpinions.containsKey(param)) {
                            MessageDialog.openError(getShell(), "Validation Error", 
                                    "Opinion for parameter " + param + " has already been assigned.");
                        } else {
                            parameterOpinions.put(param, values);
                            TableItem item = new TableItem(table, SWT.NONE);
                            item.setText(new String[] { param, 
                                    String.format("(%.3f, %.3f, %.3f, %.3f, %.3f)", values[0], values[1], values[2], values[3], values[4]) });
                        }
                    }
                }
            });

            setControl(container);
        }

        private List<String> getParameterList() {
            if (provnPage != null) {
                return provnPage.getParameterList();
            }
            return Collections.emptyList();
        }

        public Map<String, double[]> getParameterOpinions() {
            return parameterOpinions;
        }
    }

    // --- Parameter Assignment Dialog ---
    class ParameterAssignmentDialog extends Dialog {
        private Combo parameterCombo;
        private Text beliefText, disbeliefText, uncertaintyText, aPrioriText, scannedValueText;
        private String selectedParameter;
        private double[] opinionValues;
        private List<String> parameterList;
        private Map<String, Double> parameterAPrioriMap;

        protected ParameterAssignmentDialog(Shell parentShell, List<String> parameterList, Map<String, Double> parameterAPrioriMap) {
            super(parentShell);
            this.parameterList = parameterList;
            this.parameterAPrioriMap = parameterAPrioriMap;
        }

        @Override
        protected Control createDialogArea(Composite parent) {
            Composite container = (Composite) super.createDialogArea(parent);
            container.setLayout(new GridLayout(2, false));

            Label paramLabel = new Label(container, SWT.NONE);
            paramLabel.setText("Parameter:");
            parameterCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
            parameterCombo.setItems(parameterList.toArray(new String[0]));
            parameterCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            parameterCombo.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    String selected = parameterCombo.getText();
                    if (parameterAPrioriMap.containsKey(selected)) {
                        scannedValueText.setText(String.valueOf(parameterAPrioriMap.get(selected)));
                    } else {
                        scannedValueText.setText("");
                    }
                    aPrioriText.setText("0.5");
                }
            });

            Label beliefLabel = new Label(container, SWT.NONE);
            beliefLabel.setText("Belief:");
            beliefText = new Text(container, SWT.BORDER);
            beliefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

            Label disbeliefLabel = new Label(container, SWT.NONE);
            disbeliefLabel.setText("Disbelief:");
            disbeliefText = new Text(container, SWT.BORDER);
            disbeliefText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

            Label uncertaintyLabel = new Label(container, SWT.NONE);
            uncertaintyLabel.setText("Uncertainty:");
            uncertaintyText = new Text(container, SWT.BORDER);
            uncertaintyText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

            Label aPrioriLabel = new Label(container, SWT.NONE);
            aPrioriLabel.setText("A-priori:");
            aPrioriText = new Text(container, SWT.BORDER);
            aPrioriText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

            Label scannedValueLabel = new Label(container, SWT.NONE);
            scannedValueLabel.setText("Scanned Value:");
            scannedValueText = new Text(container, SWT.BORDER);
            scannedValueText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            scannedValueText.setEditable(false); // This field is read-only

            return container;
        }

        @Override
        protected void okPressed() {
            selectedParameter = parameterCombo.getText();
            try {
                double belief = Double.parseDouble(beliefText.getText());
                double disbelief = Double.parseDouble(disbeliefText.getText());
                double uncertainty = Double.parseDouble(uncertaintyText.getText());
                double aPriori = Double.parseDouble(aPrioriText.getText());
                double scannedValue = Double.parseDouble(scannedValueText.getText());
                opinionValues = new double[]{belief, disbelief, uncertainty, aPriori, scannedValue};
            } catch (NumberFormatException e) {
                MessageDialog.openError(getShell(), "Input Error", "Please enter valid numerical values.");
                return;
            }
            super.okPressed();
        }

        public String getSelectedParameter() {
            return selectedParameter;
        }

        public double[] getOpinionValues() {
            return opinionValues;
        }
    }
}
