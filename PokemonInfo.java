public class PokemonInfo {
    private String name;
    private String type;
    private int level;

    public PokemonInfo (String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public String toString() {
        return "[Name: " + this.name.toUpperCase() + " Type: " + this.type.toUpperCase() + " Level: " + this.level + "]";
    }

}
