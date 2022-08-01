package cdio.group21.digital_learning_app.ui.util

import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

object ButtonAnimations {

    fun fadeIn(button: AppCompatButton){
        button.animate().apply {
            duration = 150
            this.alpha(1f)
        }.start()
    }

    fun fadeOut(button : AppCompatButton){
        button.animate().apply {
            duration = 110
            this.alpha(0.1f)
        }.start()
    }

    fun clickButton(button : AppCompatButton){
        button.animate().apply {
            duration = 75
            this.scaleXBy(-0.1f)
            this.scaleYBy(-0.1f)
            this.alpha(0.5f)
        }.withEndAction {
            button.animate().apply {
                duration = 75
                this.scaleXBy(0.1f)
                this.scaleYBy(0.1f)
                this.alpha(1f)
            }
        }.start()
    }

    fun clickButtonFade(button : AppCompatButton){
        button.animate().apply {
            duration = 75
            this.scaleXBy(-0.1f)
            this.scaleYBy(-0.1f)
            this.alpha(0.5f)
        }.withEndAction {
            button.animate().apply {
                duration = 75
                this.scaleXBy(0.1f)
                this.scaleYBy(0.1f)
                this.alpha(0.2f)
            }
        }.start()
    }

    fun clickText(tv : TextView){
        tv.animate().apply {
            duration = 55
            this.scaleXBy(-0.1f)
            this.scaleYBy(-0.1f)
            this.alpha(1f)
        }.withEndAction {
            tv.animate().apply {
                duration = 55
                this.scaleXBy(0.1f)
                this.scaleYBy(0.1f)
                this.alpha(0.5f)
            }
        }.start()
    }

    fun clickImageButton(button : ImageButton){
        button.animate().apply {
            duration = 75
            this.scaleXBy(-0.1f)
            this.scaleYBy(-0.1f)
            this.alpha(0.3f)
        }.withEndAction {
            button.animate().apply {
                duration = 75
                this.scaleXBy(0.1f)
                this.scaleYBy(0.1f)
                this.alpha(1f)
            }
        }.start()
    }

    fun clickCardView(card: CardView){
        card.animate().apply {
            duration = 75
            this.scaleXBy(-0.1f)
            this.scaleYBy(-0.1f)
            this.alpha(0.5f)
        }.withEndAction {
            card.animate().apply {
                duration = 75
                this.scaleXBy(0.1f)
                this.scaleYBy(0.1f)
                this.alpha(1f)
            }
        }.start()
    }
}