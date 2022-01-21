package libs;


public class Pair<K,V> {
        /**
         * Key of this <code>Pair</code>.
         */
        private K key;

        /**
         * Gets the key for this pair.
         * @return key for this pair
         */
        public K getKey() { return key; }

        /**
         * Value of this this <code>Pair</code>.
         */
        private V value;

        /**
         * Gets the value for this pair.
         * @return value for this pair
         */
        public V getValue() { return value; }
}
