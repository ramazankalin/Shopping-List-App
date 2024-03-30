package com.example.RamazanKalin

open class Item(var name : String, var price : Double) {
}

class Food(name: String, price: Double, val weight: Double) : Item(name, price) {
}

class Cloth(name: String, price: Double, val type: String) : Item(name, price) {
}

class ShoppingList {
    var items = ArrayList<Item>()

    fun addItem(item : Item) {
        items.add(item)
        println("${item.name} is added successfully!")
    }

    fun displayItem() {
        println("Your shopping list:")
        for (item in items) {
            if (item is Food) {
                println("${item.name} ${item.price}$ ${item.weight}kg")
            } else if (item is Cloth) {
                println("${item.name} ${item.price}$ ${item.type}")
            }
        }
    }

    fun deleteItem(item : Item) {
        items.remove(item)
        println("${item.name} is deleted successfully!")
    }
}

fun main() {
    println("***** Welcome to Shopping List App *****")
    val shoppingList = ShoppingList()
    do {
        print("Make your choice : (1-2-3-4)\n1.Add Item\n2.Display Item\n3.Delete Item\n4.Exit\nYour choice is : ")
        var choiceProcess = readln().toInt()
        while (choiceProcess < 1 || choiceProcess > 4) {
            println("İnvalid number. Make your choice : ")
            choiceProcess = readln().toInt()
        }
        when (choiceProcess) {
            1 -> {
                print("Enter the item type you want to add (1 for Food, 2 for Cloth) : ")
                var choiceProcess2 = readln().toInt()
                while (choiceProcess2 != 1 && choiceProcess2 != 2) {
                    println("İnvalid number. Enter the item type you want to add (1 for Food, 2 for Cloth) : ")
                    choiceProcess2 = readln().toInt()
                }
                if (choiceProcess2 == 1) {
                    print("Please enter the name : ")
                    val foodName = readln().toString()
                    print("Please enter the price : ")
                    var foodPrice = readln().toDoubleOrNull()
                    while (foodPrice == null) {
                        println("Please enter valid price! : ")
                        foodPrice = readln().toDoubleOrNull()
                    }
                    print("Please enter the weight : ")
                    var foodWeight = readln().toDoubleOrNull()
                    while (foodWeight == null) {
                        println("Please enter valid weight! : ")
                        foodWeight = readln().toDoubleOrNull()
                    }
                    val foodItem = Food(foodName, foodPrice, foodWeight)
                    shoppingList.addItem(foodItem)
                }
                else {
                    print("Please enter the name : ")
                    val clothName = readln().toString()
                    print("Please enter the price : ")
                    var clothPrice = readln().toDoubleOrNull()
                    while (clothPrice == null) {
                        println("Please enter valid price! : ")
                        clothPrice = readln().toDoubleOrNull()
                    }
                    print("Please enter the type : ")
                    val clothType = readln().toString()
                    val clothItem = Cloth(clothName, clothPrice, clothType)
                    shoppingList.addItem(clothItem)
                }
            }
            2 -> shoppingList.displayItem()
            3 -> {
                print("Enter the name of the item you want to delete: ")
                val itemName = readln().toString()
                var found = false
                for (item in shoppingList.items) {
                    if (item.name == itemName) {
                        shoppingList.deleteItem(item)
                        found = true
                        break
                    }
                }
                if (!found) {
                    println("Item not found in the list.")
                }
            }
            4 -> println("Exiting...")
        }
        println("----------------------------------------")
    }
    while (choiceProcess != 4)
}


