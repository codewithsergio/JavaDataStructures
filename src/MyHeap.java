public class MyHeap {
    private int[] heapArray;
    private int size = 0;
    MyHeap(int size){
        this.heapArray = new int[size];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int value: heapArray){
            sb.append(value).append(",");
        }
        return sb.toString();
    }

    public void insert(int value){
        size++;
        int currentIndex = size > 1 ? size-1: 0;
        heapArray[currentIndex] = value;
        int parentIndex = (currentIndex - 1) / 2;
        if(parentIsLessThanChild(parentIndex, currentIndex)) // check if we need to bubbleUp
            bubbleUp(currentIndex, parentIndex);
    }

    public void remove() throws Exception {
        if(size == 0){
            throw new Exception("Nothing to remove, add a value first.");
        }
        if(size == 1){ // set root to null ( 0 )
            heapArray[0] = 0;
            return;
        }
        heapArray[0] = heapArray[size - 1]; // set root to last value
        heapArray[size - 1] = 0;
        size--;
        bubbleDown();
    }

    private void bubbleUp(int cIndex, int pIndex){
        int hold = 0;
        while(true){
            if(cIndex != 0 && parentIsLessThanChild(pIndex, cIndex)){ // if parent is smaller, then swap
                swap(pIndex, cIndex);
                cIndex = pIndex;
                pIndex = (cIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private void bubbleDown(){
        int parentIndex = 0;
        int leftIndex;
        int rightIndex;
        while(true){
            leftIndex = parentIndex * 2 + 1;// left child
            rightIndex = parentIndex * 2 + 2; // right child
            if(!parentSmallerThanChildren(parentIndex, leftIndex, rightIndex)) return;
            if(heapArray[leftIndex] > heapArray[rightIndex]){
                swap(leftIndex, parentIndex);
                parentIndex = leftIndex;
            } else {
                swap(rightIndex, parentIndex);
                parentIndex = rightIndex;
            }
        }
    }

    private boolean parentSmallerThanChildren(int p, int l, int r){
        return heapArray[p] < heapArray[l] || heapArray[p] < heapArray[r];
    }

    private boolean parentIsLessThanChild(int p, int c){
        return heapArray[p] < heapArray[c];
    }

    private void swap(int p, int c){
        int hold = heapArray[p];
        heapArray[p] = heapArray[c];
        heapArray[c] = hold;
    }
}
