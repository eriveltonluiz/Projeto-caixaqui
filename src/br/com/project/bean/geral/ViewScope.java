package br.com.project.bean.geral;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.FacesRequestAttributes;

@SuppressWarnings("unchecked")
public class ViewScope implements Scope, Serializable {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callBacks";
	
	//O método get é a operação central de um Scope, e a única operação que é absolutamente necessária.
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object instancia = getViewMap().get(name);
		if(instancia == null) {
			instancia = objectFactory.getObject();
			getViewMap().put(name, instancia);
		}
		return instancia;
	}

	@Override
	public String getConversationId() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(context);
		
		return facesRequestAttributes.getSessionId() + "-" + context.getViewRoot().getViewId();
	}

	@Override
	public void registerDestructionCallback(String name, Runnable runnable) {
		Map<String, Runnable> callBacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
		if(callBacks != null) {
			callBacks.put(VIEW_SCOPE_CALLBACKS, runnable);
		}
	}

	@Override
	public Object remove(String name) {
		Object instance = getViewMap().remove(name);
		if(instance != null) {
			Map<String, Runnable> callBacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
			
			if(callBacks != null) {
				callBacks.remove(name);
			}
		}
		return instance;
	}

	@Override
	public Object resolveContextualObject(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(context);
		return facesRequestAttributes.resolveReference(name);
	}

	// getViewRoot retorna o componente raiz que está associado a esta
	// solicitação(request)
	// getViewMap retorna
	private Map<String, Object> getViewMap() {
		return FacesContext.getCurrentInstance() != null ? FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				: new HashMap<String, Object>();
	}

}
