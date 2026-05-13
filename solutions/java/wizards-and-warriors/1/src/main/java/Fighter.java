class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    public String toString() {
        return "Fighter is a Warrior";
    }
    
    @Override
    public boolean isVulnerable() {
        return false;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }
}

// TODO: define the Wizard class
class Wizard extends Fighter {
    private int countOfSpellFunctionCalled = 0;
    
    public String toString() {
        return "Fighter is a Wizard";
    }

    public void prepareSpell() {
        countOfSpellFunctionCalled++;
    }

    @Override
    public boolean isVulnerable(){
        return countOfSpellFunctionCalled == 0 ? true : false;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return countOfSpellFunctionCalled > 0 ? 12 : 3;
    }
}