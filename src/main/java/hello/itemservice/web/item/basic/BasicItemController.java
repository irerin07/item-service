package hello.itemservice.web.item.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);

        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {

        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String save(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam int quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String saveV2(@ModelAttribute("item") Item item,
                       Model model) {
        //ModelAttribute는 지정된 모델 객체를 만들어 주고 자동으로 model에 지정된 이름("item")으로 넣어준다.

        itemRepository.save(item);

//        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String saveV3(@ModelAttribute Item item) {
        //ModelAttribute는 지정된 모델 객체를 만들어 주고 자동으로 model에 지정된 이름("item")으로 넣어준다.
        //이름을 따로 지정하지 않으면 efault로 지정된 모델 객체의 이름으로 "item" model에 넣어준다.

        itemRepository.save(item);

//        model.addAttribute("item", item);

        return "basic/item";
    }

    @PostMapping("/add")
    public String saveV4(Item item) {
        //ModelAttribute는 지정된 모델 객체를 만들어 주고 자동으로 model에 지정된 이름("item")으로 넣어준다.
        //이름을 따로 지정하지 않으면 efault로 지정된 모델 객체의 이름으로 "item" model에 넣어준다.
        //ModelAttribute도 생략 가능하다.

        itemRepository.save(item);

//        model.addAttribute("item", item);

        return "basic/item";
    }
}