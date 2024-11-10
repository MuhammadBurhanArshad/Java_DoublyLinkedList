public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        int registrationID = 2312395;
        String idString = String.valueOf(registrationID);
        for (char c : idString.toCharArray()) {
            list.insert(Character.getNumericValue(c));
        }

        System.out.println("Original List:");
        list.displayList();

        list.reverse();
        System.out.println("Reversed List:");
        list.displayList();

        list.deleteAlternateNodes();
        System.out.println("List after deleting alternate nodes:");
        list.displayList();

        list.swapNodes(1, 9);
        System.out.println("List after swapping nodes 1 and 9:");
        list.displayList();

        int occurrences = list.countOccurrences(1);
        System.out.println("Occurrences of 1: " + occurrences);

        list.insertAfter(5, 2);
        System.out.println("List after inserting 5 after node with data 2:");
        list.displayList();
    }
}
