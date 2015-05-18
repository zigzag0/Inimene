package ee.ttu.idu0020.inimene;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class InimeneValidator {

	private static final Logger log = Logger.getLogger(InimeneValidator.class);

	public Map<String, String> validate(Inimene i) {
		Map<String, String> errors = new HashMap<>();

		// inimene_name1
		if (i.getName1() == null || i.getName1().isEmpty())
			errors.put("inimene_name1",
					"Nime koht on tühi kuid peab olema täis! Palun tippige nimi...");
		else if (i.getName1() != null && i.getName1().length() > 20)
			errors.put("inimene_name1", "Nimi liiga pikk, peaks olema vähem kui 20 TM.");

		// inimene_name2
		if (i.getName2() == null || i.getName2().isEmpty())
			errors.put("inimene_name2",
					"Perekonna nime koht on tühi kuid peab olema täis! Palun tippige perekonna nimi...");
		else if (i.getName2().length() > 20)
			errors.put("inimene_name2", "Perekonnanimi liiga pikk, peaks olema vähem kui 20 TM");

		if (i.getNumber() != null && i.getNumber() >= 100000)
			errors.put("inimene_number", "järjekorra arv on liiga suur peab olema alla 1000");


		if (i.getBday() == null )
			errors.put("inimene_bday", "kuupäev on vales formaadis, peaks olema YYYY-MM-DD (näiteks 2012-10-19)");


		if (!errors.isEmpty()) {
			log.warn("Validation failed: " + errors);
		}

		return errors;
	}
}
