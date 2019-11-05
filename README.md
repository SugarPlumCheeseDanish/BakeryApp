# BakeryApp


# The Assignment

## Your favorite bakery needs to create a database of its fresh goods!

You're in a team of 2.

Create at least 15 baked goods and save it into a collection of data. 
Each baked good has a name, price, an expiration date, one or more diet restrictions (ie. gluten allergies), and quantity in stock.
The program should allow the user to search by diet restrictions and print all matching results.
For a list of example products, see https://sensitivesweets.com/collections/breads


All processes must happen in Classes, not in the main method of a Main class.

<hr/>
<em><b>Sample Output:</em><b/>
  
```console
Welcome to the Brookley's Better Bakery App! 
We contain peanut, gluten, soy and dairy in our products. 

To search for foods that you can eat, please enter the name of the diet restriction: 
To see a list of all our foods, please type "all".
```

# Our Implementation

## Group members:
Pierz and Ksenia

## Class Structure:

### BakeryItem
This contains fields :
- String name
- double price
- String expiration
- ArrayList<String> diet :: lists the dietary restrictions MET by this item
- int stock :: how many are in stock

Note that we had to implement a copySelf method to return a copy of `this` BakeryItem.

### BakeryDB
Implements **Singleton Pattern**

- The class consists of one field: `private ArrayList<BakeryItem> itemsList`
- It has only one constructor which is ONLY CALLED ONCE.

To accomplish this, it has a class-level private STATIC self-reference 
which is `private static BakeryDB single_instance = null` 
and a STATIC public method called 'getInstance' 
which will call the constructor only if single_instance is null.

In either case, the getInstance method returns single_instance.

### Main
Implements the main user-interface logic for the database interactions.

We chose not to create a ShoppingCart class, instead, we have a local ArrayList<BakeryItem> 
which we populate based on selections made from our in-main BakeryDB (singleton) instance. 

Note that when we were collecting items into the Shopping Cart 
we had to create the "copySelf" method for BakeryItem. 
Not sure if this is because we use so many ArrayLists, 
or because of our super-tight SINGLETON pattern that we're using.