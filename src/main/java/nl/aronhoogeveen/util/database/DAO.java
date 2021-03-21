package nl.aronhoogeveen.util.database;

import java.util.Optional;
import java.util.Map;
import java.util.Collection;

/**
 * DAO is a basic Data Access Object interface. It defines the most simple, but useful, methods for a good Data Access
 * Object.
 *
 * @param <T> the class that this DAO will provide the data access for
 */
public interface DAO<T> {

    /**
     * Checks if there exists an instance for the provided identifier {@code id}.
     *
     * @param id the identifier
     * @return {@code true} if such an instance exists, {@code false} otherwise
     * @throws DAOException if an error occurred
     */
    boolean exists(int id) throws DAOException;

    /**
     * Retrieves the instance with identifier {@code id}.
     *
     * @param id the identifier
     * @return an optional with a Map.Entry for the object, or no object if it is not found
     * @throws DAOException if an error occurred
     */
    Optional<T> get(int id) throws DAOException;

    /**
     * Returns a mapping of the instance with identifier {@code id}.
     *
     * @param id the identifier
     * @return a mapping for the instance
     * @throws DAOException if an error occurred
     */
    Optional<Map.Entry<Integer, T>> getMapping(int id) throws DAOException;

    /**
     * Returns a Collection of all instances.
     *
     * @return Collection of all instances
     * @throws DAOException if an error occurred
     */
    Collection<T> getAll() throws DAOException;

    /**
     * Returns a map with all instances and their keys (identifiers)
     *
     * @return a map with all mappings
     * @throws DAOException if an error occurred
     */
    Map<Integer, T> getMap() throws DAOException;

    /**
     * Update the instance identified by {@code id}.
     *
     * @param id the identifier
     * @param t the new object value
     * @throws DAOException if an error occurred
     */
    void update(int id, T t) throws DAOException;

    /**
     * Update the instance identified by {@code id}. Instead of throwing an exception this method will return {@code false}.
     *
     * @param id the identifier
     * @param t the new object value
     */
    boolean updateValue(int id, T t);

    /**
     * Adds the instance to the underlying data structure.
     *
     * @param t the instance to add
     * @return the identifier for retrieving the instance
     * @throws DAOException if an error occurred
     */
    int add(T t) throws DAOException;

    /**
     * Adds the instance to the underlying data structure. Instead of throwing an exception this method will return
     * {@code false}.
     *
     * @param t the instance to add
     * @return {@code true} if the instance was successfully added, {@code false} otherwise
     */
    boolean addValue(T t);

    /**
     * Adds all instances in the Collection {@code col} to the underlying data structure.
     *
     * @param col collection of instances to add
     * @throws DAOException if an error occurred
     */
    void addAll(Collection<T> col) throws DAOException;

    /**
     * Deletes the instance associated with identifier {@code id}.
     *
     * @param id the identifier
     * @throws DAOException if an error occurred
     */
    void delete(int id) throws DAOException;

    /**
     * Deletes the instance associated with identifier {@code id}. Instead of throwing an exception this will return
     * {@code false}.
     *
     * @param id the identifier
     * @return {@code true} if the identifier was successfully deleted, {@code false} otherwise
     */
    boolean deleteValue(int id);

    /**
     * If this Data Access Object uses some form of connection, calling this method will close the connection, otherwise
     * this is a no-op.
     *
     * @throws DAOException if an error occurred
     */
    void close() throws DAOException;
}
