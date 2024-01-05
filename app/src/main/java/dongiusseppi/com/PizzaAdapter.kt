package dongiusseppi.com.PizzaAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dongiusseppi.com.Pizza
import dongiusseppi.com.R

class PizzaAdapter(private val pizzaList: ArrayList<Pizza>)
    :RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>(){
    class PizzaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imagePizza)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent,false)
        return PizzaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.imageView.setImageResource(pizza.image)
    }
}