package decomposer_plugin.handlers;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The wizard page that lets the user choose the three files.
 */
class InputFilesWizardPage extends WizardPage {

    private Text emodlText;
    private Text provnText;
    private Text jsonText;

    protected InputFilesWizardPage() {
        super("Input Files");
        setTitle("Input Files");
        setDescription("Select the EMODL, PROVN, and JSON cluster files.");
    }

    @Override
    public void createControl(Composite parent) {
        // Create a container with a grid layout.
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(3, false));

        // EMODL file selection
        Label emodlLabel = new Label(container, SWT.NONE);
        emodlLabel.setText("EMODL File:");
        emodlText = new Text(container, SWT.BORDER);
        emodlText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Button emodlButton = new Button(container, SWT.PUSH);
        emodlButton.setText("Browse...");
        emodlButton.addListener(SWT.Selection, e -> {
            FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
            dialog.setFilterExtensions(new String[] { "*.emodl", "*.*" });
            String path = dialog.open();
            if (path != null) {
                emodlText.setText(path);
                validate();
            }
        });

        // PROVN file selection
        Label provnLabel = new Label(container, SWT.NONE);
        provnLabel.setText("PROVN File:");
        provnText = new Text(container, SWT.BORDER);
        provnText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Button provnButton = new Button(container, SWT.PUSH);
        provnButton.setText("Browse...");
        provnButton.addListener(SWT.Selection, e -> {
            FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
            dialog.setFilterExtensions(new String[] { "*.provn", "*.*" });
            String path = dialog.open();
            if (path != null) {
                provnText.setText(path);
                validate();
            }
        });

        // JSON file selection
        Label jsonLabel = new Label(container, SWT.NONE);
        jsonLabel.setText("JSON File:");
        jsonText = new Text(container, SWT.BORDER);
        jsonText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Button jsonButton = new Button(container, SWT.PUSH);
        jsonButton.setText("Browse...");
        jsonButton.addListener(SWT.Selection, e -> {
            FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
            dialog.setFilterExtensions(new String[] { "*.json", "*.*" });
            String path = dialog.open();
            if (path != null) {
                jsonText.setText(path);
                validate();
            }
        });

        // Optionally, you can add ModifyListeners to the text widgets to validate input on the fly.
        ModifyListener modifyListener = e -> validate();
        emodlText.addModifyListener(modifyListener);
        provnText.addModifyListener(modifyListener);
        jsonText.addModifyListener(modifyListener);

        setControl(container);
        validate();
    }

    /**
     * Validates that all fields have nonempty file paths.
     */
    private void validate() {
        if (emodlText.getText().trim().isEmpty() ||
            provnText.getText().trim().isEmpty() ||
            jsonText.getText().trim().isEmpty()) {
            setErrorMessage("All three file paths must be specified.");
            setPageComplete(false);
        } else {
            setErrorMessage(null);
            setPageComplete(true);
        }
    }

    public String getEmodlFile() {
        return emodlText.getText().trim();
    }

    public String getProvnFile() {
        return provnText.getText().trim();
    }

    public String getJsonFile() {
        return jsonText.getText().trim();
    }
}
