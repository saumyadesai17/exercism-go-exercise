import java.util.Map;
import java.util.HashMap;

public class DialingCodes {
    private Map<Integer, String> dialingCodes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return dialingCodes;
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!(dialingCodes.containsKey(code) || dialingCodes.containsValue(country))) {
            dialingCodes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        int code = 0;
        if (!dialingCodes.containsValue(country)) {
            return null;
        }
        for (Map.Entry<Integer, String> entry : dialingCodes.entrySet()) {
            if (entry.getValue() == country) {
                code = entry.getKey();
                break;
            }
        }
        return code;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer countryCode = findDialingCode(country);
        if (countryCode != null) {
            dialingCodes.remove(countryCode);
            setDialingCode(code, country);
        }
    }
}
