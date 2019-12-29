package Http.Display;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class DisplayPropertiesController implements Serializable {
	private static final long serialVersionUID = 1L;
	private String locale;

	private static Map<String,Object> countries;
	static {

		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("French", Locale.FRENCH);
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	//value change event listener
	public void localeChanged(ValueChangeEvent e) {
		String newLocaleValue = e.getNewValue().toString();

		for (Map.Entry<String, Object> entry : countries.entrySet()) {

			if(entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance()
						.getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
	}
}