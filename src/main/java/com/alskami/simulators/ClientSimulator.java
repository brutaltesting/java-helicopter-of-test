package com.alskami.simulators;

import com.alskami.simulators.controllers.ControllerType;
import com.alskami.simulators.controllers.IController;
import com.alskami.simulators.controllers.login.ILoginController;
import com.alskami.simulators.controllers.signup.ISignUpController;
import com.alskami.simulators.model.IModel;
import com.alskami.simulators.model.ModelType;
import com.alskami.simulators.model.user.UserModel;
import com.alskami.simulators.service.rest.IRESTService;
import com.alskami.simulators.service.rest.RESTServiceType;
import com.alskami.simulators.views.IView;
import com.alskami.simulators.views.ViewType;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientSimulator implements Serializable{

    // Controllers
    protected Map<ControllerType, IController> controllerHolder = new HashMap<>();
    // Views
    protected Map<ViewType, IView> viewHolder = new HashMap<>();
    // REST-services
    protected Map<RESTServiceType, IRESTService> restServiceHolder = new HashMap<>();
    // Models
    protected Map<ModelType, IModel> modelHolder = new HashMap<>();

    // Event listeners
    protected Set<IClientSimulatorListener> listenerHolder = new HashSet<>();

    public void addController(ControllerType controllerType, IController controller) {
        controller.setSimulator(this);
        controllerHolder.put(controllerType, controller);

    }
    public IController getController(ControllerType controllerType) {
        return controllerHolder.get(controllerType);
    }

    public void addView(ViewType viewType, IView view) {
        viewHolder.put(viewType, view);
    }
    public IView getView(ViewType viewType) {
        return viewHolder.get(viewType);
    }

    public void addRestService(RESTServiceType restServiceType, IRESTService restService) {
        restService.setSimulator(this);
        IRESTService oldservice = restServiceHolder.put(restServiceType, restService);
        if(oldservice != null && oldservice instanceof IClientSimulatorListener) {
            removeListener((IClientSimulatorListener) oldservice);
        }
        if(restService instanceof IClientSimulatorListener) {
            addListener((IClientSimulatorListener) restService);
        }
    }

    public void addModel(ModelType modelType, IModel model) {
        modelHolder.put(modelType, model);
    }
    public IModel getModel(ModelType modelType) {
        return modelHolder.get(modelType);
    }

    private void removeListener(IClientSimulatorListener listener) {
        listenerHolder.remove(listener);
    }
    public void addListener(IClientSimulatorListener listener) {
        listenerHolder.add(listener);
    }

// Getters and setters
    public ISignUpController getSignUpController() {
        return (ISignUpController) getController(ControllerType.SIGN_UP);
    }

    public void setSignUpController(ISignUpController signUpController) {
        addController(ControllerType.SIGN_UP, signUpController);
    }

	public UserModel getUserModel() {
		return ((UserModel)getModel(ModelType.USER));
	}
	public void setUserModel(UserModel userModel) {addModel(ModelType.USER, userModel);}


	public ILoginController getLoginController() {
        return (ILoginController) getController(ControllerType.LOGIN);
	}
	public void setLoginController(ILoginController loginController) {
        addController(ControllerType.LOGIN, loginController);
	}



    public void notifyListeners(ClientSimulatorEvent event) {
        listenerHolder.forEach((listener)->listener.listen(event));
    }

    /**
     * Returns a copy of the object, or null if the object cannot
     * be serialized.
     */
    public static ClientSimulator copy(ClientSimulator origEmulator) {
        ClientSimulator clientSimulatorRes = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(origEmulator);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            clientSimulatorRes = (ClientSimulator) in.readObject();
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientSimulatorRes;
    }



    @Override
	public String toString() {
		//return toJson();
        StringBuilder builder = new StringBuilder();
        builder.append("\n {\"clientEmulator\": [");
        String prefix = "";
        for(ModelType type : ModelType.values()) {
            IModel model = getModel(type);
            if(model != null) {
                builder.append(prefix);
                builder.append("{\"").append(type.name().toLowerCase()).append("Model\": ").append(model).append("}");
                prefix = ", ";
            }
        }
        return builder.toString();
	}


}
