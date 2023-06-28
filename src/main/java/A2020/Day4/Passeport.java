package A2020.Day4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Passeport {
    private String birth;
    private String issue;
    private String expiration;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String id;
    private String countryID;

    public Passeport(String input) {
        //S'il n'y a pas la chaine le [1] sera rien car tous sera dans le 0
        if (input.split("byr:").length > 1) {
            this.birth = input.split("byr:")[1].split(" ")[0];
        } else {
            this.birth = "";
        }
        if (input.split("iyr:").length > 1) {
            this.issue = input.split("iyr:")[1].split(" ")[0];
        } else {
            this.issue = "";
        }
        if (input.split("eyr:").length > 1) {
            this.expiration = input.split("eyr:")[1].split(" ")[0];
        } else {
            this.expiration = "";
        }
        if (input.split("hgt:").length > 1) {
            this.height = input.split("hgt:")[1].split(" ")[0];
        } else {
            this.height = "";
        }
        if (input.split("hcl:").length > 1) {
            this.hairColor = input.split("hcl:")[1].split(" ")[0];
        } else {
            this.hairColor = "";
        }
        if (input.split("ecl:").length > 1) {
            this.eyeColor = input.split("ecl:")[1].split(" ")[0];
        } else {
            this.eyeColor = "";
        }
        if (input.split("pid:").length > 1) {
            this.id = input.split("pid:")[1].split(" ")[0];
        } else {
            this.id = "";
        }
        if (input.split("cid:").length > 1) {
            this.countryID = input.split("cid:")[1].split(" ")[0];
        } else {
            this.countryID = "";
        }
    }

    public boolean isValid() {
        return !"".equals(this.birth) && !Objects.equals(this.issue, "") && !Objects.equals(this.expiration, "") && !Objects.equals(this.height, "") && !Objects.equals(this.hairColor, "") && !Objects.equals(this.eyeColor, "") && !Objects.equals(this.id, "");
    }

    public boolean isValidV2() {
        if (!this.isValid())
            return false;

        if (this.birth.length() != 4 || parseInteger(this.birth) == null) {
            return false;
        }
        if (parseInteger(this.birth) <1920 || parseInteger(this.birth) > 2002)
            return false;

        if (this.issue.length() != 4 || parseInteger(this.issue) == null)
            return false;
        if (parseInteger(this.issue) <2010 || parseInteger(this.issue) > 2020)
            return false;

        if (this.expiration.length() != 4 || parseInteger(this.expiration) == null)
            return false;
        if (parseInteger(this.expiration) <2020 || parseInteger(this.expiration) > 2030)
            return false;

        int h;
        if (!this.height.contains("cm") && !this.height.contains("in"))
            return false;
        if(this.height.contains("cm")) {
            h = parseInteger(this.height.split("cm")[0]);
            if (h<150 || h>193)
                return false;
        } else {
            h = parseInteger(this.height.split("in")[0]);
            if (h<59 || h>76)
                return false;
        }

        if(!this.hairColor.startsWith("#"))
            return false;
        if (!this.hairColor.toUpperCase().substring(1).matches("[0-9A-F]{6}"))
            return false;

        List<String> eyesColor = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        if(!eyesColor.contains(this.eyeColor))
            return false;

        if(this.id.length() != 9 || parseInteger(this.id) == null)
            return false;

        return true;
    }

    public Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
