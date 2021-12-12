package ru.arta999.lemonade

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val LEMONADE_STATE = "LEMONADE_STATE"
    private val LEMON_SIZE = "LEMON_SIZE"
    private val SQUEEZE_COUNT = "SQUEEZE_COUNT"

    // SELECT represents the "pick lemon" state
    private val SELECT = "select"

    // SQUEEZE represents the "squeeze lemon" state
    private val SQUEEZE = "squeeze"

    // DRINK represents the "drink lemonade" state
    private val DRINK = "drink"

    // RESTART represents the state where the lemonade has be drunk and the glass is empty
    private val RESTART = "restart"

    // Default the state to select
    private var lemonadeState = "select"

    // Default lemonSize to -1
    private var lemonSize = -1

    // Default the squeezeCount to -1
    private var squeezeCount = -1

    private var lemonTree = LemonTree()
    private var lemonImage: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // === DO NOT ALTER THE CODE IN THE FOLLOWING IF STATEMENT ===
        if (savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }
        // === END IF STATEMENT ===

        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        lemonImage!!.setOnClickListener {
            // TODO: вызвать метод, который обрабатывает состояние при нажатии на изображение
            clickLemonImage()
        }
        lemonImage!!.setOnLongClickListener {
            // TODO: замените false на вызов функции, которая показывает счетчик сжатий
            //false
            showSnackbar()

        }
    }

    /**
     * === НЕ ИЗМЕНЯЙТЕ ЭТО ===
     *
     * Этот метод сохраняет состояние приложения, если оно помещается в фоновый режим..
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putInt(LEMON_SIZE, lemonSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    /**
     * Нажатие вызовет различный ответ в зависимости от состояния.
     * Этот метод определяет состояние и приступает к правильному действию.
     */
    private fun clickLemonImage() {
        // TODO: используйте условный оператор, такой как 'if' или 'when', чтобы отслеживать состояние лимонада
        //        // при щелчке по изображению нам может потребоваться изменить состояние на следующий шаг в
        //        // лимонад прогрессирует (или, по крайней мере, вносит некоторые изменения в текущее состояние в
        //        // случай выдавливания лимона). Это должно быть сделано в этом условном операторе


        // TODO: При щелчке по изображению в состоянии ВЫБРАТЬ состояние должно измениться на СЖАТИЕ.
        //        // - Переменная лимонного размера должна быть установлена SQUEEZE с помощью метода pick () в классе LemonTree
        //        // - squeezeCount должен быть 0, так как мы еще не сжали ни одного лимона.

/*        if (lemonadeState == SELECT) {
            lemonadeState = SQUEEZE
            lemonSize = lemonTree.pick()
            squeezeCount = 0
        } */

        // TODO: Если щелкнуть изображение в состоянии SQUEEZE, squeezeCount должен быть
        //        // УВЕЛИЧИВАЕТСЯ на 1, а размер лимона нужно УМЕНЬШИТЬ на 1.
        //        // - Если размер лимона достиг 0, он был выделен и состояние должно стать НАПИТОК
        //        // - Кроме того, lemonSize больше не актуален и должен быть установлен в -1



        // TODO: При щелчке по изображению в состоянии DRINK состояние должно измениться на  RESTART



        // TODO: При щелчке по изображению RESTART state the state должен стать SELECT



        if (lemonadeState == SELECT) {
            lemonadeState = SQUEEZE
            lemonSize = lemonTree.pick()
            squeezeCount = 0
        } else         if (lemonadeState == SQUEEZE) {
            squeezeCount += 1
            lemonSize -= 1
            if (lemonSize == 0) {
                lemonadeState = DRINK
                lemonSize = -1
            }
        } else  if (lemonadeState == DRINK) {
            lemonadeState == RESTART
        } else  {
            lemonadeState = SELECT
        }

        // TODO: наконец, прежде чем функция завершится, нам нужно установить элементы представления так, чтобы
        //        // UI может отражать правильное состояние


        setViewElements()
    }

    /**
     * Настройте элементы просмотра в соответствии с состоянием.
     */
    private fun setViewElements() {
/*        val textAction: TextView = findViewById(R.id.text_action)
        // TODO: настроить условие, которое отслеживает состояние лимонада
        // TODO: для каждого состояния textAction TextView должен быть установлен на соответствующую строку из
        //        // файл строковых ресурсов. Строки названы в соответствии с состоянием
        when (lemonadeState) {
            SELECT -> textAction.setText(R.string.lemon_select)
            SQUEEZE -> textAction.setText(R.string.lemon_squeeze)
            DRINK -> textAction.setText(R.string.lemon_drink)
            RESTART -> textAction.setText(R.string.lemon_empty_glass)
        }
        // TODO: Кроме того, для каждого состояния для свойства LemonImage должно быть установлено соответствующее значение.
        //        // извлекаем из доступных ресурсов. У чертежей те же имена, что и у строк
        //        // но помните, что это чертежи, а не строки.
        when (lemonadeState) {
            SELECT -> lemonImage?.setImageResource(R.drawable.lemon_tree)
            SQUEEZE -> lemonImage?.setImageResource(R.drawable.lemon_squeeze)
            DRINK -> lemonImage?.setImageResource(R.drawable.lemon_drink)
            RESTART -> lemonImage?.setImageResource(R.drawable.lemon_restart)
        } */

        when (lemonadeState) {
            SELECT -> updateUi(R.string.lemon_select, R.drawable.lemon_tree)
            SQUEEZE -> updateUi(R.string.lemon_squeeze, R.drawable.lemon_squeeze)
            DRINK -> updateUi(R.string.lemon_drink, R.drawable.lemon_drink)
            RESTART -> updateUi(R.string.lemon_empty_glass, R.drawable.lemon_restart)
        }
    }

    private fun updateUi(displayText: Int, displayImage: Int) {
        val textAction: TextView = findViewById(R.id.text_action)
        textAction.setText(displayText)
        lemonImage?.setImageResource(displayImage)
    }

    /**
     * === НЕ ИЗМЕНЯЙТЕ ЭТО ===
     *
     * Долгое нажатие на изображение лимона покажет, сколько раз был выжат лимон.
     */
    private fun showSnackbar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

/**
 * Класс Lemon tree с методом «сорвать» лимон. «Размер» лимона случайный.
 * и определяет, сколько раз нужно выжать лимон, прежде чем вы его получите.
 */
class LemonTree {
    fun pick(): Int {
        return (2..4).random()

    }
}