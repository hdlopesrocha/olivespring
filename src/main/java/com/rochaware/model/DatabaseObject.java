package com.rochaware.model;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class DatabaseObject {

	
	/** The client. */
	private static MongoClient client;
	
	/** The database. */
	private static MongoDatabase database;
	
	/** The db. */
	private static DB db;
	
	/** The last oid. */
	static long lastOid = 0l;
	
	/** The db name. */
	private static String DB_NAME = "bullray";
	
	private static String DB_HOST = "localhost:27017";
	
	
	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public synchronized static MongoClient getClient() {
		if (client == null) {
			try {
				client = new MongoClient(DB_HOST);
			}catch(Exception e){
				client = new MongoClient(ServerAddress.defaultHost());
			}
		}
		return client;
	}
	
	/**
	 * Inits the.
	 *
	 * @param dbname the dbname
	 */
	public static void init(String dbname, String dbhost){
		DB_NAME = dbname;
		DB_HOST = dbhost;
		db = null;
		database = null;
	}
	
	/**
	 * Gets the db.
	 *
	 * @return the db
	 */
	@SuppressWarnings("deprecation")
	public synchronized static DB getDB() {
		if (db == null) {
			db = getClient().getDB(DB_NAME);
		}
		return db;
	}

	/**
	 * Gets the database.
	 *
	 * @return the database
	 */
	public synchronized static MongoDatabase getDatabase() {
		if (database == null) {
			database = getClient().getDatabase(DB_NAME);
		}
		return database;
	}
	
	public static MongoCollection<Document> getCollection(String name){
		return getDatabase().getCollection(name);
	}
	
	public static MongoCollection<Document> getCollection(Class<?> clazz){
		return getCollection(clazz.getName());		
	}
	
	private ObjectId id;
	
	
	
	
	public DatabaseObject(){
		this.id = null;
	}
	
	public DatabaseObject(Document doc){
		this.id = doc.getObjectId("_id");
	}
	

	/**
	 * Save.
	 *
	 * @return the alert
	 */
	public final DatabaseObject save() {
		Document doc = toDocument();
		if(getId()!=null){
			doc.put("_id", getId());
		}
		if (getId() == null) {
			getCollection(this.getClass()).insertOne(doc);
			setId(doc.getObjectId("_id"));
		} else {
			getCollection(this.getClass()).findOneAndReplace(new Document("_id", getId()), doc);
		}
		return this;
	}



	public ObjectId getId() {
		return id;
	}
	
	/**
	 * Delete.
	 */
	public final void delete() {
		if (getId() != null) {
			getCollection(getClass()).deleteOne(new Document("_id", getId()));
		}
	}

	
	protected void setId(ObjectId id) {
		this.id = id;
	}

	protected abstract Document toDocument();
	

}
