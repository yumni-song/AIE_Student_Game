package demo2.shop;

//Item 클래스
public class Item {
  private String name;
  private int price; //지불 가격(경험치)
  private int value; //체력 회복량
  private ItemType type;

  //생성자
  public Item(String name, int price, int value, ItemType type) {
      this.name = name;
      this.price = price;
      this.value = value;
      this.type = type;

  }

  // getter들
  public String getName() { return name; }
  public int getPrice() { return price; }
  public int getValue() { return value; }
  public ItemType getType() { return type; }

}
