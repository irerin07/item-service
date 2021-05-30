package hello.itemservice.domain.item;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemA, int i, int i1) {
        this.itemName = itemA;
        this.price = i;
        this.quantity = i1;
    }
}
