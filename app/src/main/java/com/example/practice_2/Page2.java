package com.example.practice_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.location.LocationManager;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.mapview.MapView;

public class Page2 extends AppCompatActivity {
    private MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        MapKitFactory.initialize(this);

        // Укажите имя Activity вместо map.
        setContentView(R.layout.activity_page2);
        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(new Point(56.0184, 92.8672), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        LocationManager locationManager = MapKitFactory.getInstance().createLocationManager();

        mapview.getMap().

                move(
                        new CameraPosition(new Point(56.0184, 92.8672), 11.0f, 0.0f, 0.0f),
                        new

                                Animation(Animation.Type.SMOOTH, 0),
                        null);

        mapview.getMap().addInputListener(new InputListener() {
            @Override
            public void onMapTap(@NonNull Map map, @NonNull Point point) {
                mapview.getMap().getMapObjects().clear();
                Log.d("MAP_TAG", "point: " + point.getLatitude() + ", " +
                        point.getLongitude());

                mapview.getMap().getMapObjects().addPlacemark(new Point(point.getLatitude(),
                        point.getLongitude()));
            }

            @Override
            public void onMapLongTap(@NonNull Map map, @NonNull Point point) {

            }
            public Bitmap drawSimpleBitmap(String number) {
                int picSize = 10;
                Bitmap bitmap = Bitmap.createBitmap(picSize, picSize*2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                // отрисовка плейсмарка
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(picSize / 2, picSize / 2, picSize / 2, paint);
                // отрисовка текста
                paint.setColor(Color.WHITE);
                paint.setAntiAlias(true);
                paint.setTextSize(10);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(number, picSize / 2,
                        picSize / 2 - ((paint.descent() + paint.ascent()) / 2), paint);
                return bitmap;
            }

        });
    }
    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    public void notes(View v){
        Intent myIntent = new Intent(this, MainActivity2.class);
        startActivity(myIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }

}