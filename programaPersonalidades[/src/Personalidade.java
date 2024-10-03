
public class Personalidade {
    
    private String nome;
    private String shortDescription;
    private String gender;
    private String country;
    private String occupation;
    private String birthYear;
    private String deathYear;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
    public String getDeathYear() {
        return deathYear;
    }
    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }
    public Personalidade(String nome, String shortDescription, String gender, String country, String occupation,
            String birthYear, String deathYear) {
        this.nome = nome;
        this.shortDescription = shortDescription;
        this.gender = gender;
        this.country = country;
        this.occupation = occupation;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
    
}
