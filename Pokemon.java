import java.util.List;

public interface Pokemon extends Comparable<Pokemon>{
  public String getName();
  public List<String> getType();
  public int getHP();
  public int getTotal();
  public int getAttack();
  public int getDefense();
  public int getSpeed();
  public int getGen();
  public boolean isLegendary();
  public int compareTo(Pokemon otherPokemon);
}
