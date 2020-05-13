/*
 * CBM interface
 * Dit document beschrijft de interface van CBM die ten behoeve van Melvin beschikbaar wordt gesteld. . </br></br> De API moet worden uitgevraagd met een token. De token kan met een gebruikersnaam en wachtwoord verkregen worden. De token is tijdelijk geldig, daarna kan een nieuwe token opgevraagd worden. </br></br> De Geo-inputparameters moeten matchen op de door CBM gebruikte OSM-versie.
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T10:23:11.877Z")
public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) return;

        this.name = name;
    }

    private void setValue(String value) {
        if (!isValidString(value)) return;

        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) return false;
        if (arg.trim().isEmpty()) return false;

        return true;
    }
}
