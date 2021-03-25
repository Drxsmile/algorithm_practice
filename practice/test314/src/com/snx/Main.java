package com.snx;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/*

 */

// Frugal Fulfillment
// A customer order has an ItemID, a desired quantity, a minimum delivery speed, and a shipping location. PickerService takes in ItemID and return a list of warehouses with their available quantity of that item. PricingService returns a cost given an ItemID, quantity, warehouse, delivery speed, and shipping location.  Can you write me code to find the cheapest way to fulfill an order?

A, B, C
        a  a  a
        3  20 50



        C1: a - 7 -> 5 deliver (addr)...

        PickerService -> func(itemId) -> (A, itemid, number)


        每个仓库：
        1. 数量不够
        2. 数量正好/多


        PricingService -> func(ItemID, quantity, warehouse, delivery speed, and shipping location) -> cost  30   50


        遍历 -> 最低cost

class CustomerOrder{
    int itemId;
    int quantity;
    int sla;
    String location;
}
class Warehouse{
    String id; // location, addr, phone...

    int itemId;
    int quantity;

}
    public int minimumCost(CustomerOrder order){
        List<Warehouse> list = pickerService(order.id);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            Warehouse w = list.get(i);
            if(w.quantity >= num){
                int cost = pricingService(id, num, w.id, sla, loc);
                min = Math.min(min, cost);
            }else{

            }
        }



        return min;

        List<Integer> l;
        l.add(7); O(1)
        l.get(); O(1)

        l.remove(); O(1)
        l.remove(0); O(n)
        l.add(0, 100) O(n)


        LinkedList 1->3  v.s. ArrayList [1,3]

        Collection.sort(l);   nLogn
        Array.sort();
    }




    A(a, cost: 10)
    B(b, cost: 5)
C...

        a+b+...+ >=n
        sum(cost) min



// 1. 具体问题抽象成刷过的抽象问题
// 2. 数据结构，抽象化




// 如何有效率刷题
// leetcode.
//   KMP算法







