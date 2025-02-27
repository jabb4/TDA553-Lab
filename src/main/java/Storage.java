public interface Storage<T>{
    void load(T item, double[] storageCords);
    Object unload(double[] storageCords);
    int getStorageSize();
}
