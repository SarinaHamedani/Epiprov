package org.plugin.geodes.trustassessment.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.plugin.geodes.trustassessment.FusionWizard;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

public class SampleHandler extends AbstractHandler {

	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Obtain the active shell from the workbench.
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        
        // Create and open the wizard.
        FusionWizard wizard = new FusionWizard();
        WizardDialog dialog = new WizardDialog(shell, wizard);
        dialog.open();
        return null;
    }
}
