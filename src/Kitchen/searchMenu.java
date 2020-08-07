package Kitchen;
import Waiter.*;
import java.util.*;

interface searchMenu extends foodMenu{
    public Stack checkItem(Queue<FoodItem> OrderQueue);
  }

  // Sub-Interface