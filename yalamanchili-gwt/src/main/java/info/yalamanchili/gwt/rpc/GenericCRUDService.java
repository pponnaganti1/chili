package info.yalamanchili.gwt.rpc;

import info.yalamanchili.gwt.beans.TableObj;

import java.util.List;
import java.util.Map;

import net.sf.gilead.pojo.java5.LightEntity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface GenericCRUDService extends RemoteService {
	public <T extends LightEntity> T create(T entity);

	public <T extends LightEntity> void merge(T entity, T parent);

	public <T extends LightEntity> T read(T entity, Long id);

	public <T extends LightEntity> T update(T entity);

	public <T extends LightEntity> void delete(T entity);

	public <T extends LightEntity> TableObj<T> getTableObj(T entity, int start);

	public <T extends LightEntity> List<T> getAllEntities(T entity);

	public <T extends LightEntity> List<T> getRelatedEntities(Long entityID,
			String sourceClass, T target);

	public <T extends LightEntity> List<String> getSuggestionsForName(
			String name, T entity);

	public <T extends LightEntity> List<T> getEntities(T entity);

	public <T extends LightEntity> Map<Long, String> getListBoxValues(T entity,
			String[] columns);

	public <T extends LightEntity> void addAll(T parent, T child,
			List<Long> children);

	public static class GenericCRUDServiceAsync {

		private static info.yalamanchili.gwt.rpc.GenericCRUDServiceAsync genericcrud;

		public static synchronized info.yalamanchili.gwt.rpc.GenericCRUDServiceAsync instance() {
			if (genericcrud == null) {
				genericcrud = (info.yalamanchili.gwt.rpc.GenericCRUDServiceAsync) GWT
						.create(GenericCRUDService.class);
				ServiceDefTarget endpoint = (ServiceDefTarget) genericcrud;
				String moduleRelativeURL = GWT.getModuleBaseURL()
						+ "genericcrud";
				endpoint.setServiceEntryPoint(moduleRelativeURL);
			}
			return genericcrud;
		}
	}

}
