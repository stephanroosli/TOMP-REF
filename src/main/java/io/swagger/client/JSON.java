/*
 * Transport Operator MaaS Provider API
 * An API between MaaS providers and transport operators for booking trips and corresponding assets. <p>The documentation (examples, process flows and sequence diagrams) can be found at <a href=\"https://github.com/TOMP-WG/TOMP-API/\">github</a>.
 *
 * OpenAPI spec version: 1.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.PostProcessor;
import io.gsonfire.TypeSelector;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import io.swagger.model.*;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class JSON {
	private Gson gson;
	private boolean isLenientOnJson = false;
	private DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
	private SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
	private OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
	private LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();

	public static GsonBuilder createGson() {
		GsonFireBuilder fireBuilder = new GsonFireBuilder()
				.registerTypeSelector(BookingOption.class, new TypeSelector<BookingOption>() {
					@Override
					public Class<? extends BookingOption> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends BookingOption>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("booking".toUpperCase(), Booking.class);
						classByDiscriminatorValue.put("BookingOption".toUpperCase(), BookingOption.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, ""));
					}
				}).registerPostProcessor(BookingOption.class, new PostProcessor<BookingOption>() {
					@Override
					public void postDeserialize(BookingOption result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, BookingOption src, Gson gson) {
						Map<Class<? extends BookingOption>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(Booking.class, "booking");
						discriminatorValueByClass.put(BookingOption.class, "BookingOption");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("")) {
								((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				}).registerTypeSelector(PlanningResult.class, new TypeSelector<PlanningResult>() {
					@Override
					public Class<? extends PlanningResult> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends PlanningResult>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("composit-leg".toUpperCase(), CompositLeg.class);
						classByDiscriminatorValue.put("simple-leg".toUpperCase(), SimpleLeg.class);
						classByDiscriminatorValue.put("PlanningResult".toUpperCase(), PlanningResult.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, "result-type"));
					}
				}).registerPostProcessor(PlanningResult.class, new PostProcessor<PlanningResult>() {
					@Override
					public void postDeserialize(PlanningResult result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, PlanningResult src, Gson gson) {
						Map<Class<? extends PlanningResult>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(CompositLeg.class, "composit-leg");
						discriminatorValueByClass.put(SimpleLeg.class, "simple-leg");
						discriminatorValueByClass.put(PlanningResult.class, "PlanningResult");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("result-type")) {
								((JsonObject) result).addProperty("result-type",
										discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				}).registerTypeSelector(Condition.class, new TypeSelector<Condition>() {
					@Override
					public Class<? extends Condition> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends Condition>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("deposit-condition".toUpperCase(), DepositCondition.class);
						classByDiscriminatorValue.put("pay-when-finished-condition".toUpperCase(),
								PayWhenFinishedCondition.class);
						classByDiscriminatorValue.put("postponed-commit-condition".toUpperCase(),
								PostponedCommitCondition.class);
						classByDiscriminatorValue.put("require-booking-data-condition".toUpperCase(),
								RequireBookingDataCondition.class);
						classByDiscriminatorValue.put("return-area-condition".toUpperCase(), ReturnAreaCondition.class);
						classByDiscriminatorValue.put("upfront-payment-condition".toUpperCase(),
								UpfrontPaymentCondition.class);
						classByDiscriminatorValue.put("Condition".toUpperCase(), Condition.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, "conditionType"));
					}
				}).registerPostProcessor(Condition.class, new PostProcessor<Condition>() {
					@Override
					public void postDeserialize(Condition result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, Condition src, Gson gson) {
						Map<Class<? extends Condition>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(DepositCondition.class, "deposit-condition");
						discriminatorValueByClass.put(PayWhenFinishedCondition.class, "pay-when-finished-condition");
						discriminatorValueByClass.put(PostponedCommitCondition.class, "postponed-commit-condition");
						discriminatorValueByClass.put(RequireBookingDataCondition.class,
								"require-booking-data-condition");
						discriminatorValueByClass.put(ReturnAreaCondition.class, "return-area-condition");
						discriminatorValueByClass.put(UpfrontPaymentCondition.class, "upfront-payment-condition");
						discriminatorValueByClass.put(Condition.class, "Condition");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("conditionType")) {
								((JsonObject) result).addProperty("conditionType",
										discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				}).registerTypeSelector(AmountOfMoney.class, new TypeSelector<AmountOfMoney>() {
					@Override
					public Class<? extends AmountOfMoney> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends AmountOfMoney>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("extra-costs".toUpperCase(), ExtraCosts.class);
						classByDiscriminatorValue.put("fare-part".toUpperCase(), FarePart.class);
						classByDiscriminatorValue.put("journal-entry".toUpperCase(), JournalEntry.class);
						classByDiscriminatorValue.put("AmountOfMoney".toUpperCase(), AmountOfMoney.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, ""));
					}
				}).registerPostProcessor(AmountOfMoney.class, new PostProcessor<AmountOfMoney>() {
					@Override
					public void postDeserialize(AmountOfMoney result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, AmountOfMoney src, Gson gson) {
						Map<Class<? extends AmountOfMoney>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(ExtraCosts.class, "extra-costs");
						discriminatorValueByClass.put(FarePart.class, "fare-part");
						discriminatorValueByClass.put(JournalEntry.class, "journal-entry");
						discriminatorValueByClass.put(AmountOfMoney.class, "AmountOfMoney");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("")) {
								((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				}).registerTypeSelector(SimpleLeg.class, new TypeSelector<SimpleLeg>() {
					@Override
					public Class<? extends SimpleLeg> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends SimpleLeg>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("operator-leg".toUpperCase(), OperatorLeg.class);
						classByDiscriminatorValue.put("SimpleLeg".toUpperCase(), SimpleLeg.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, ""));
					}
				}).registerPostProcessor(SimpleLeg.class, new PostProcessor<SimpleLeg>() {
					@Override
					public void postDeserialize(SimpleLeg result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, SimpleLeg src, Gson gson) {
						Map<Class<? extends SimpleLeg>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(OperatorLeg.class, "operator-leg");
						discriminatorValueByClass.put(SimpleLeg.class, "SimpleLeg");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("")) {
								((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				}).registerTypeSelector(Period.class, new TypeSelector<Period>() {
					@Override
					public Class<? extends Period> getClassForElement(JsonElement readElement) {
						Map<String, Class<? extends Period>> classByDiscriminatorValue = new HashMap<>();
						classByDiscriminatorValue.put("options-leg".toUpperCase(), OptionsLeg.class);
						classByDiscriminatorValue.put("planning-check".toUpperCase(), PlanningCheck.class);
						classByDiscriminatorValue.put("token".toUpperCase(), Token.class);
						classByDiscriminatorValue.put("Period".toUpperCase(), Period.class);
						return getClassByDiscriminator(classByDiscriminatorValue,
								getDiscriminatorValue(readElement, ""));
					}
				}).registerPostProcessor(Period.class, new PostProcessor<Period>() {
					@Override
					public void postDeserialize(Period result, JsonElement src, Gson gson) {

					}

					@Override
					public void postSerialize(JsonElement result, Period src, Gson gson) {
						Map<Class<? extends Period>, String> discriminatorValueByClass = new HashMap<>();
						discriminatorValueByClass.put(OptionsLeg.class, "options-leg");
						discriminatorValueByClass.put(PlanningCheck.class, "planning-check");
						discriminatorValueByClass.put(Token.class, "token");
						discriminatorValueByClass.put(Period.class, "Period");
						if (result instanceof JsonObject) {
							if (!((JsonObject) result).has("")) {
								((JsonObject) result).addProperty("", discriminatorValueByClass.get(src.getClass()));
							}
						}
					}
				});
		return fireBuilder.createGsonBuilder();
	}

	private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
		JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
		if (null == element) {
			throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
		}
		return element.getAsString();
	}

	private static <T> Class<? extends T> getClassByDiscriminator(
			Map<String, Class<? extends T>> classByDiscriminatorValue, String discriminatorValue) {
		Class<? extends T> clazz = classByDiscriminatorValue.get(discriminatorValue.toUpperCase());
		if (null == clazz) {
			throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
		}
		return clazz;
	}

	public JSON() {
		gson = createGson().registerTypeAdapter(Date.class, dateTypeAdapter)
				.registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter)
				.registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter)
				.registerTypeAdapter(LocalDate.class, localDateTypeAdapter).create();
	}

	/**
	 * Get Gson.
	 *
	 * @return Gson
	 */
	public Gson getGson() {
		return gson;
	}

	/**
	 * Set Gson.
	 *
	 * @param gson
	 *            Gson
	 * @return JSON
	 */
	public JSON setGson(Gson gson) {
		this.gson = gson;
		return this;
	}

	public JSON setLenientOnJson(boolean lenientOnJson) {
		isLenientOnJson = lenientOnJson;
		return this;
	}

	/**
	 * Serialize the given Java object into JSON string.
	 *
	 * @param obj
	 *            Object
	 * @return String representation of the JSON
	 */
	public String serialize(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * Deserialize the given JSON string to Java object.
	 *
	 * @param <T>
	 *            Type
	 * @param body
	 *            The JSON string
	 * @param returnType
	 *            The type to deserialize into
	 * @return The deserialized Java object
	 */
	@SuppressWarnings("unchecked")
	public <T> T deserialize(String body, Type returnType) {
		try {
			if (isLenientOnJson) {
				JsonReader jsonReader = new JsonReader(new StringReader(body));
				// see
				// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
				jsonReader.setLenient(true);
				return gson.fromJson(jsonReader, returnType);
			} else {
				return gson.fromJson(body, returnType);
			}
		} catch (JsonParseException e) {
			// Fallback processing when failed to parse JSON form response body:
			// return the response body string directly for the String return type;
			if (returnType.equals(String.class))
				return (T) body;
			else
				throw (e);
		}
	}

	/**
	 * Gson TypeAdapter for JSR310 OffsetDateTime type
	 */
	public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

		private DateTimeFormatter formatter;

		public OffsetDateTimeTypeAdapter() {
			this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}

		public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
			this.formatter = formatter;
		}

		public void setFormat(DateTimeFormatter dateFormat) {
			this.formatter = dateFormat;
		}

		@Override
		public void write(JsonWriter out, OffsetDateTime date) throws IOException {
			if (date == null) {
				out.nullValue();
			} else {
				out.value(formatter.format(date));
			}
		}

		@Override
		public OffsetDateTime read(JsonReader in) throws IOException {
			switch (in.peek()) {
			case NULL:
				in.nextNull();
				return null;
			default:
				String date = in.nextString();
				if (date.endsWith("+0000")) {
					date = date.substring(0, date.length() - 5) + "Z";
				}
				return OffsetDateTime.parse(date, formatter);
			}
		}
	}

	/**
	 * Gson TypeAdapter for JSR310 LocalDate type
	 */
	public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

		private DateTimeFormatter formatter;

		public LocalDateTypeAdapter() {
			this(DateTimeFormatter.ISO_LOCAL_DATE);
		}

		public LocalDateTypeAdapter(DateTimeFormatter formatter) {
			this.formatter = formatter;
		}

		public void setFormat(DateTimeFormatter dateFormat) {
			this.formatter = dateFormat;
		}

		@Override
		public void write(JsonWriter out, LocalDate date) throws IOException {
			if (date == null) {
				out.nullValue();
			} else {
				out.value(formatter.format(date));
			}
		}

		@Override
		public LocalDate read(JsonReader in) throws IOException {
			switch (in.peek()) {
			case NULL:
				in.nextNull();
				return null;
			default:
				String date = in.nextString();
				return LocalDate.parse(date, formatter);
			}
		}
	}

	public JSON setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
		offsetDateTimeTypeAdapter.setFormat(dateFormat);
		return this;
	}

	public JSON setLocalDateFormat(DateTimeFormatter dateFormat) {
		localDateTypeAdapter.setFormat(dateFormat);
		return this;
	}

	/**
	 * Gson TypeAdapter for java.sql.Date type If the dateFormat is null, a simple
	 * "yyyy-MM-dd" format will be used (more efficient than SimpleDateFormat).
	 */
	public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

		private DateFormat dateFormat;

		public SqlDateTypeAdapter() {
		}

		public SqlDateTypeAdapter(DateFormat dateFormat) {
			this.dateFormat = dateFormat;
		}

		public void setFormat(DateFormat dateFormat) {
			this.dateFormat = dateFormat;
		}

		@Override
		public void write(JsonWriter out, java.sql.Date date) throws IOException {
			if (date == null) {
				out.nullValue();
			} else {
				String value;
				if (dateFormat != null) {
					value = dateFormat.format(date);
				} else {
					value = date.toString();
				}
				out.value(value);
			}
		}

		@Override
		public java.sql.Date read(JsonReader in) throws IOException {
			switch (in.peek()) {
			case NULL:
				in.nextNull();
				return null;
			default:
				String date = in.nextString();
				try {
					if (dateFormat != null) {
						return new java.sql.Date(dateFormat.parse(date).getTime());
					}
					return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
				} catch (ParseException e) {
					throw new JsonParseException(e);
				}
			}
		}
	}

	/**
	 * Gson TypeAdapter for java.util.Date type If the dateFormat is null,
	 * ISO8601Utils will be used.
	 */
	public static class DateTypeAdapter extends TypeAdapter<Date> {

		private DateFormat dateFormat;

		public DateTypeAdapter() {
		}

		public DateTypeAdapter(DateFormat dateFormat) {
			this.dateFormat = dateFormat;
		}

		public void setFormat(DateFormat dateFormat) {
			this.dateFormat = dateFormat;
		}

		@Override
		public void write(JsonWriter out, Date date) throws IOException {
			if (date == null) {
				out.nullValue();
			} else {
				String value;
				if (dateFormat != null) {
					value = dateFormat.format(date);
				} else {
					value = ISO8601Utils.format(date, true);
				}
				out.value(value);
			}
		}

		@Override
		public Date read(JsonReader in) throws IOException {
			try {
				switch (in.peek()) {
				case NULL:
					in.nextNull();
					return null;
				default:
					String date = in.nextString();
					try {
						if (dateFormat != null) {
							return dateFormat.parse(date);
						}
						return ISO8601Utils.parse(date, new ParsePosition(0));
					} catch (ParseException e) {
						throw new JsonParseException(e);
					}
				}
			} catch (IllegalArgumentException e) {
				throw new JsonParseException(e);
			}
		}
	}

	public JSON setDateFormat(DateFormat dateFormat) {
		dateTypeAdapter.setFormat(dateFormat);
		return this;
	}

	public JSON setSqlDateFormat(DateFormat dateFormat) {
		sqlDateTypeAdapter.setFormat(dateFormat);
		return this;
	}

}