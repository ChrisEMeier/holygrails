package nfjs

class Quest {
    String name
    
    String toString() { name }
    
    static constraints = {
        name(blank:false)
    }
}
