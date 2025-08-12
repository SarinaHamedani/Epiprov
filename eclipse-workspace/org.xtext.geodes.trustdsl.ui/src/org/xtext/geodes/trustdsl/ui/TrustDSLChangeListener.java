package org.xtext.geodes.trustdsl.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

public class TrustDSLChangeListener implements IResourceChangeListener {
	@Override
    public void resourceChanged(IResourceChangeEvent event) {
        try {
            IResourceDelta rootDelta = event.getDelta();
            if (rootDelta != null) {
                rootDelta.accept(new IResourceDeltaVisitor() {
                    @Override
                    public boolean visit(IResourceDelta delta) throws CoreException {
                        IResource resource = delta.getResource();
                        if (resource.getType() == IResource.FILE && "trustdsl".equals(resource.getFileExtension())) {
                            String path = resource.getFullPath().toString();
                            switch (delta.getKind()) {
                                case IResourceDelta.ADDED:
                                    System.out.println("Added: " + path);
                                    break;
                                case IResourceDelta.REMOVED:
                                    System.out.println("Removed: " + path);
                                    break;
                                case IResourceDelta.CHANGED:
                                    System.out.println("Changed: " + path);
                                    break;
                            }
                        }
                        return true;
                    }
                });
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }
}
