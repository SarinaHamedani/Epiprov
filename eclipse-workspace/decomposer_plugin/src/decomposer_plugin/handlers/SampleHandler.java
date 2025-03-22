package decomposer_plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleHandler extends AbstractHandler {

//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"Decomposer_plugin",
//				"Hello, Eclipse world");
//		return null;
//	}
	
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        // Create and open the wizard dialog
        DecomposerWizard wizard = new DecomposerWizard();
        WizardDialog dialog = new WizardDialog(shell, wizard);
        if (dialog.open() == Window.OK) {
            // Optionally add post-finish logic here.
        }
        return null;
    }
}



