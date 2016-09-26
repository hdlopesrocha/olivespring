package com.rochaware;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * The Class Tools.
 */
public class Tools {

	/** The Constant DATE_FORMAT. */
	private static final DateFormat DATE_FORMAT;// = new
												// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	private static final DateFormat NUMBER_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	static {
		TimeZone tz = TimeZone.getTimeZone("UTC");

		DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		DATE_FORMAT.setTimeZone(tz);
	}

	public static final String guessContentType(String filename) {
		int extensionPosition = filename.lastIndexOf(".");
		String extension = filename.substring(extensionPosition, filename.length());

		switch (extension) {
		case ".ai":
			return "application/postscript";
		case ".aif":
			return "audio/aiff";
		case ".aifc":
			return "audio/aiff";
		case ".aiff":
			return "audio/aiff";
		case ".aps":
			return "application/mime";
		case ".arj":
			return "application/arj";
		case ".asp":
			return "text/asp";
		case ".avi":
			return "video/avi";
		case ".bm":
			return "image/bmp";
		case ".bmp":
			return "image/bmp";
		case ".c":
			return "text/plain";
		case ".c++":
			return "text/plain";
		case ".cc":
			return "text/plain";
		case ".class":
			return "application/java";
		case ".conf":
			return "text/plain";
		case ".css":
			return "text/css";
		case ".dl":
			return "video/dl";
		case ".doc":
			return "application/msword";
		case ".dwg":
			return "application/acad";
		case ".dxf":
			return "application/dxf";
		case ".eps":
			return "application/postscript";
		case ".evy":
			return "application/envoy";
		case ".f":
			return "text/plain";
		case ".fif":
			return "application/fractals";
		case ".fli":
			return "video/fli";
		case ".flo":
			return "image/florian";
		case ".for":
			return "text/plain";
		case ".frl":
			return "application/freeloader";
		case ".funk":
			return "audio/make";
		case ".g":
			return "text/plain";
		case ".g3":
			return "image/g3fax";
		case ".gif":
			return "image/gif";
		case ".gl":
			return "video/gl";
		case ".h":
			return "text/plain";
		case ".hh":
			return "text/plain";
		case ".hlp":
			return "application/hlp";
		case ".hqx":
			return "application/binhex";
		case ".hta":
			return "application/hta";
		case ".htm":
			return "text/html";
		case ".html":
			return "text/html";
		case ".htmls":
			return "text/html";
		case ".htt":
			return "text/webviewhtml";
		case ".htx":
			return "text/html";
		case ".idc":
			return "text/plain";
		case ".ief":
			return "image/ief";
		case ".iefs":
			return "image/ief";
		case ".iges":
			return "application/iges";
		case ".igs":
			return "application/iges";
		case ".inf":
			return "application/inf";
		case ".it":
			return "audio/it";
		case ".ivr":
			return "i-world/i-vrml";
		case ".jav":
			return "text/plain";
		case ".java":
			return "text/plain";
		case ".jfif":
			return "image/jpeg";
		case ".jfif-tbnl":
			return "image/jpeg";
		case ".jpe":
			return "image/jpeg";
		case ".jpeg":
			return "image/jpeg";
		case ".jpg":
			return "image/jpeg";
		case ".js":
			return "application/javascript";
		case ".jut":
			return "image/jutvision";
		case ".kar":
			return "audio/midi";
		case ".la":
			return "audio/nspaudio";
		case ".list":
			return "text/plain";
		case ".lma":
			return "audio/nspaudio";
		case ".log":
			return "text/plain";
		case ".lst":
			return "text/plain";
		case ".lzx":
			return "application/lzx";
		case ".m":
			return "text/plain";
		case ".m1v":
			return "video/mpeg";
		case ".m2a":
			return "audio/mpeg";
		case ".m2v":
			return "video/mpeg";
		case ".mar":
			return "text/plain";
		case ".mbd":
			return "application/mbedlet";
		case ".mcd":
			return "application/mcad";
		case ".mcf":
			return "image/vasa";
		case ".mid":
			return "audio/midi";
		case ".midi":
			return "audio/midi";
		case ".mime":
			return "www/mime";
		case ".mm":
			return "application/base64";
		case ".mme":
			return "application/base64";
		case ".mod":
			return "audio/mod";
		case ".moov":
			return "video/quicktime";
		case ".mov":
			return "video/quicktime";
		case ".mp2":
			return "audio/mpeg";
		case ".mp3":
			return "audio/mpeg3";
		case ".mp4":
			return "video/mp4";
		case ".mpa":
			return "audio/mpeg";
		case ".mpe":
			return "video/mpeg";
		case ".mpeg":
			return "video/mpeg";
		case ".mpg":
			return "video/mpeg";
		case ".mpga":
			return "audio/mpeg";
		case ".mrc":
			return "application/marc";
		case ".my":
			return "audio/make";
		case ".nap":
			return "image/naplps";
		case ".naplps":
			return "image/naplps";
		case ".oda":
			return "application/oda";
		case ".part":
			return "application/pro_eng";
		case ".pas":
			return "text/pascal";
		case ".pdf":
			return "application/pdf";
		case ".pfunk":
			return "audio/make";
		case ".pic":
			return "image/pict";
		case ".pict":
			return "image/pict";
		case ".pl":
			return "text/plain";
		case ".png":
			return "image/png";
		case ".pps":
			return "application/mspowerpoint";
		case ".ppt":
			return "application/powerpoint";
		case ".ppz":
			return "application/mspowerpoint";
		case ".prt":
			return "application/pro_eng";
		case ".ps":
			return "application/postscript";
		case ".qt":
			return "video/quicktime";
		case ".rast":
			return "image/cmu-raster";
		case ".rmi":
			return "audio/mid";
		case ".rng":
			return "application/ringing-tones";
		case ".rt":
			return "text/richtext";
		case ".rtf":
			return "application/rtf";
		case ".rtx":
			return "application/rtf";
		case ".s3m":
			return "audio/s3m";
		case ".sdml":
			return "text/plain";
		case ".sdp":
			return "application/sdp";
		case ".sdr":
			return "application/sounder";
		case ".sea":
			return "application/sea";
		case ".set":
			return "application/set";
		case ".sgm":
			return "text/sgml";
		case ".sgml":
			return "text/sgml";
		case ".shtml":
			return "text/html";
		case ".smi":
			return "application/smil";
		case ".smil":
			return "application/smil";
		case ".snd":
			return "audio/basic";
		case ".sol":
			return "application/solids";
		case ".spl":
			return "application/futuresplash";
		case ".ssm":
			return "application/streamingmedia";
		case ".step":
			return "application/step";
		case ".stl":
			return "application/sla";
		case ".stp":
			return "application/step";
		case ".tbk":
			return "application/toolbook";
		case ".text":
			return "text/plain";
		case ".tgz":
			return "application/gnutar";
		case ".tif":
			return "image/tiff";
		case ".tiff":
			return "image/tiff";
		case ".tsi":
			return "audio/tsp-audio";
		case ".tsp":
			return "application/dsptype";
		case ".tsv":
			return "text/tab-separated-values";
		case ".turbot":
			return "image/florian";
		case ".txt":
			return "text/plain";
		case ".uni":
			return "text/uri-list";
		case ".unis":
			return "text/uri-list";
		case ".unv":
			return "application/i-deas";
		case ".uri":
			return "text/uri-list";
		case ".uris":
			return "text/uri-list";
		case ".vda":
			return "application/vda";
		case ".vdo":
			return "video/vdo";
		case ".vew":
			return "application/groupwise";
		case ".viv":
			return "video/vivo";
		case ".vivo":
			return "video/vivo";
		case ".voc":
			return "audio/voc";
		case ".vos":
			return "video/vosaic";
		case ".vox":
			return "audio/voxware";
		case ".vrml":
			return "model/vrml";
		case ".wav":
			return "audio/wav";
		case ".webm":
			return "video/webm";
		case ".wiz":
			return "application/msword";
		case ".wmf":
			return "windows/metafile";
		case ".word":
			return "application/msword";
		case ".wp":
			return "application/wordperfect";
		case ".wp5":
			return "application/wordperfect";
		case ".wp6":
			return "application/wordperfect";
		case ".wpd":
			return "application/wordperfect";
		case ".wri":
			return "application/mswrite";
		case ".wrz":
			return "model/vrml";
		case ".wsc":
			return "text/scriplet";
		case ".xbm":
			return "image/xbm";
		case ".xl":
			return "application/excel";
		case ".xla":
			return "application/excel";
		case ".xlb":
			return "application/excel";
		case ".xlc":
			return "application/excel";
		case ".xld":
			return "application/excel";
		case ".xlk":
			return "application/excel";
		case ".xll":
			return "application/excel";
		case ".xlm":
			return "application/excel";
		case ".xls":
			return "application/excel";
		case ".xlt":
			return "application/excel";
		case ".xlv":
			return "application/excel";
		case ".xlw":
			return "application/excel";
		case ".xm":
			return "audio/xm";
		case ".xml":
			return "text/xml";
		case ".xmz":
			return "xgl/movie";
		case ".xpm":
			return "image/xpm";
		case ".zip":
			return "application/zip";

		default:
			return "application/octet-stream";
		}

	}

	/**
	 * String to date.
	 *
	 * @param str
	 *            the str
	 * @return the date
	 * @throws ParseException
	 */
	public static final Date stringToDate(String str) throws ParseException {
		return Date.from(Instant.parse(str));

		// java.util.Date date = Date.from( OffsetDateTime.parse(
		// "2014-12-12T10:39:40Z" ).toInstant());
	}

	/**
	 * Gets the current time.
	 *
	 * @return the current time
	 */
	public static String getCurrentTime() {
		return dateToString(new Date());
	}

	/**
	 * Date to string.
	 *
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static final String dateToString(Date date) {
		return DATE_FORMAT.format(date);

	}

	public static final String dateToNumber(Date date) {
		return NUMBER_FORMAT.format(date);

	}

	/**
	 * Crc.
	 *
	 * @param str
	 *            the str
	 * @return the int
	 */
	public static int crc(String str) {
		int checksum = 0;

		for (int i = 0; i < str.length(); i++) {
			checksum = checksum ^ str.charAt(i);
		}
		return checksum;
	}

	public static String msg(String str) {
		return "?" + str + "*" + Tools.str(Tools.crc(str)) + "\r\n";
	}

	/**
	 * Str.
	 *
	 * @param crc
	 *            the crc
	 * @return the string
	 */
	public static String str(int crc) {
		return String.format("%02X", crc);
	}

	/**
	 * Check.
	 *
	 * @param line
	 *            the line
	 * @return true, if successful
	 */
	public static boolean check(String line) {
		try {
			int end = line.lastIndexOf("*");
			if (end != -1) {
				String text = line.substring(1, end);
				String cstr = line.substring(end + 1, line.length());
				Integer cs = Integer.parseInt(cstr, 16);
				int checksum = crc(text);
				if (cs != checksum) {
					System.out.println(str(cs) + " (expected: " + str(checksum) + ")");
				}
				return (cs == checksum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Integer value.
	 *
	 * @param s
	 *            the s
	 * @return the integer
	 */
	public static Integer IntegerValue(String s) {
		try {
			return Integer.valueOf(s);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Double value.
	 *
	 * @param s
	 *            the s
	 * @return the double
	 */
	public static Double DoubleValue(String s) {
		try {
			return Double.valueOf(s);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Float value.
	 *
	 * @param s
	 *            the s
	 * @return the float
	 */
	public static Float FloatValue(String s) {
		try {
			return Float.valueOf(s);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Wrap.
	 *
	 * @param value
	 *            the value
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 * @return the double
	 */
	public static double Wrap(double value, double min, double max) {
		double interv = max - min;
		return value = value - interv * Math.floor(value / interv);

	}

	public static boolean isJSONObject(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			return false;
		}
		return true;
	}

	public static boolean isJSONArray(String test) {
		try {
			new JSONArray(test);
		} catch (JSONException ex) {
			return false;
		}
		return true;
	}

	public static byte[] toByteArray(InputStream is) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();

		return buffer.toByteArray();
	}


	/**
	 * Sha1.
	 *
	 * @param input
	 *            the input
	 * @return the string
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	public static String sha1(final String input)
			throws NoSuchAlgorithmException {
		final MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		final byte[] result = mDigest.digest(input.getBytes());
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	/**
	 * Gets the hash.
	 *
	 * @param password
	 *            the password
	 * @param salt
	 *            the salt
	 * @return the hash
	 */
	public static String getHash(final String password, final String salt) {
		try {
			return sha1(salt + password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static Document generateSaltHash(String pwd){
		String salt = getRandomString(32);
		Document ret = new Document();
		ret.put("salt", salt);
		ret.put("hash", getHash(pwd, salt));
		return ret;
	}

	/**
	 * Check.
	 *
	 * @param pwd the password
	 * @return true, if successful
	 */
	public static boolean checkSaltHash(String pwd, Document doc) {
		return doc!=null && pwd !=null? Tools.getHash(pwd, doc.getString("salt")).equals(doc.getString("hash")) : false;
	}

	/** The Constant allChars. */
	private static final String allChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0987654321";

	/** The random. */
	private static Random random = new Random();

	/**
	 * Gets the random salt.
	 *
	 * @param size
	 *            the size
	 * @return the random salt
	 */
	public static String getRandomString(int size) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; ++i) {
			builder.append(allChars.charAt(random.nextInt(allChars.length())));
		}
		return builder.toString();
	}
}
