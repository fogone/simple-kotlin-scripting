package ru.nobirds.kotlin.scripting

class SimpleBuilder {

    private val items = mutableListOf<SimpleItem>()

    fun item(item: SimpleItem) {
        this.items.add(item)
    }

    fun build() = SimpleModel(items)

}


fun SimpleBuilder.item(text: String) {
    item(SimpleItem(text))
}
