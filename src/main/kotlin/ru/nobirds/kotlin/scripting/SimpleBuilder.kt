package ru.nobirds.kotlin.scripting

class SimpleBuilder {

    private val items = mutableListOf<SimpleItem>()

    fun item(item: SimpleItem) {
        this.items.add(item)
    }

    fun thisIsLongMethodToFind() {
    }

    fun build() = SimpleModel(items)

}


fun SimpleBuilder.textItem(text: String) {
    item(SimpleItem(text))
}
