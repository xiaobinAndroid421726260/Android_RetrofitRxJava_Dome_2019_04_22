package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/23 9:31
 * @version V1.0
 */
public class StringTypeAdapter extends TypeAdapter<String> {

    @Override
    public String read(JsonReader reader) {
        try {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return ""; // 原先是返回null，这里改为返回空字符串
            }
            return reader.nextString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void write(JsonWriter writer, String value) {
        try {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
