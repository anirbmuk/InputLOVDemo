package blog.anirbanm.inputlov.view.bean;

import blog.anirbanm.inputlov.view.ADFUtils;
import blog.anirbanm.inputlov.view.JSFUtils;

import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.event.ReturnPopupEvent;
import oracle.adf.view.rich.render.ClientEvent;

public class BackingManager {
    
    public BackingManager() {
    }

    public void onFNameChange(ClientEvent clientEvent) {
        System.out.println((PhaseId) JSFUtils.getFacesContext().getCurrentPhaseId());
        clientEvent.getComponent().processUpdates(JSFUtils.getFacesContext());
        checkStatus();
    }
    
//    public void onFNameValueChange(ValueChangeEvent valueChangeEvent) {
//        System.out.println((PhaseId) JSFUtils.getFacesContext().getCurrentPhaseId());
//        String value = (String) valueChangeEvent.getNewValue();
//        JSFUtils.updateModel(valueChangeEvent);
//        checkStatus();
//        System.out.println(valueChangeEvent);
//    }
    
    private void checkStatus() {
        ADFUtils.findOperation("checkStatus").execute();
    }

    public void printRow(ActionEvent actionEvent) {
        System.out.println((PhaseId) JSFUtils.getFacesContext().getCurrentPhaseId());
        System.out.println(ADFUtils.findOperation("printRow").execute());
    }

    public void onPopupReturn(ReturnPopupEvent returnPopupEvent) {
        System.out.println((PhaseId) JSFUtils.getFacesContext().getCurrentPhaseId());
        checkStatus();
    }
}
