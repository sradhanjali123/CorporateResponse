package com.corporate.pojo;

import java.io.IOException;


import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BaseObject {
	private Gson gson;
	private ExclusionStrategy exclusionStrategy;
	public JsonDeserializer<Date> dateParser = new JsonDeserializer<Date>() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				System.out.println("Processing element: "+json.getAsString());
				return df.parse(json.getAsString());
			}catch (Exception e) {
				return null;
			}
		}
	};
	public BaseObject() {
		GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.setDateFormat("MM/dd/yyyy");
		gson = builder.create();
		TypeAdapter<Date> dateAdapter = gson.getAdapter(Date.class);
		dateAdapter = dateAdapter.nullSafe();
		builder.registerTypeAdapter(Date.class, dateAdapter);
		gson = builder.create();
	}
	
	public void setExclusionStrategy(ExclusionStrategy strategy) {
		this.exclusionStrategy = strategy;
		GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.addSerializationExclusionStrategy(strategy)
				.setDateFormat("MM/dd/yyyy");
		gson = builder.create();
		TypeAdapter<Date> dateAdapter = gson.getAdapter(Date.class);
		dateAdapter = dateAdapter.nullSafe();
		builder.registerTypeAdapter(Date.class, dateAdapter);
		gson = builder.create();
	}

	public String toString() {
		try {
			return gson.toJson(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
