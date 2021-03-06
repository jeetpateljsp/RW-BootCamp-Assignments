package model.caffe

import model.animals.Cat

// TODO add data, such as ID, list of products, and maybe an optional set of cats adopted/sponsored!
class Receipt (
    val id: String,
    val customerId: String,
    val product: List<Product>,
    val totalPrice: Double,
    var catsAdopted: MutableSet<Cat> = mutableSetOf()
)