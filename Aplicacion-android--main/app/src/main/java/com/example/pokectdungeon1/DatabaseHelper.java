package com.example.pokectdungeon1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dungeon.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "messages";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_MESSAGE = "message";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NUMBER + " INTEGER PRIMARY KEY, " +
                COLUMN_MESSAGE + " TEXT)";
        db.execSQL(createTable);

        // Insertar mensajes detallados para cada número del 1 al 20
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (1, 'Tu personaje murió en una trampa traicionera.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (2, 'Un golpe de suerte evitó que sufrieras una herida grave.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (3, 'Encuentras un camino alternativo y avanzas sin problemas.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (4, 'Una poción curativa te permite recuperar energías.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (5, 'Descubres una pista que podría llevarte a un tesoro.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (6, 'Escapas de una emboscada con solo algunos rasguños.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (7, 'Tu personaje encuentra un objeto antiguo y misterioso.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (8, 'Una flecha perdida pasa cerca, pero sales ileso.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (9, 'Te topas con un viejo amigo que te ayuda a continuar.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (10, 'Tu habilidad en combate mejora después de una práctica intensa.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (11, 'Encuentras una pequeña bolsa de monedas en el camino.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (12, 'Un mercader ofrece venderte un mapa a un precio razonable.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (13, 'Tu personaje evita una zona peligrosa gracias a su intuición.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (14, 'Un descanso reparador renueva tus fuerzas.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (15, 'Encuentras una espada antigua que parece tener propiedades mágicas.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (16, 'Tu personaje aprende una nueva habilidad de supervivencia.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (17, 'Te rescatan de una situación peligrosa.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (18, 'Descubres una cueva oculta llena de recursos valiosos.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (19, 'Encuentras una carta que revela una pista importante.')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (20, '¡Tu personaje encontró un tesoro escondido!')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String getMessage(int number) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_MESSAGE + " FROM " + TABLE_NAME + " WHERE " + COLUMN_NUMBER + " = ?", new String[]{String.valueOf(number)});
        String message = "";
        if (cursor.moveToFirst()) {
            message = cursor.getString(0);
        }
        cursor.close();
        return message;
    }
}
