package com.alsharany.restaurantapp

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    lateinit var adabter: PagerAdabter
    //lateinit var adabter: FragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.main_tab_layout)
        viewPager = findViewById(R.id.main_view_Pager) as ViewPager2
        /* adabter=object :FragmentStateAdapter(this){
             override fun getItemCount(): Int {
                 return 3

             }

             override fun createFragment(position: Int): Fragment {
                return when(position){
                    0-> CategoryFragment.newInstance(1, "Foods")
                    1-> {val tab=MyTab(Category(2, "Drinks"), CategoryFragment.newInstance(2, "Drinks"))
                        tab.fragment}
                    2-> CategoryFragment.newInstance(1, "Dessert")
                    else-> {val tab=MyTab(Category(2, "Drinks"), CategoryFragment.newInstance(2, "Drinks"))
                    tab.fragment}
                }
             }
         }*/
        adabter=PagerAdabter(this)
        adabter.addTab(MyTab(Category(1, "Foods"), CategoryFragment.newInstance(1, "Foods")))
        adabter.addTab(MyTab(Category(2, "Drinks"), CategoryFragment.newInstance(2, "Drinks")))
        adabter.addTab(MyTab(Category(3,"Desserts"),CategoryFragment.newInstance(3,"Desserts")))
        adabter.addTab(MyTab(Category(4,"salat"),CategoryFragment.newInstance(4,"Salat")))

        viewPager.adapter=adabter


           viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
               override fun onPageSelected(position: Int) {
                   super.onPageSelected(position)
                   Toast.makeText(this@MainActivity,"page ${position+1}",Toast.LENGTH_LONG).show()
               }
           })


        TabLayoutMediator(tabLayout,viewPager){ tap,postion ->
            when(postion){
                0->{

                    tap.text ="Food"
                    tap.setIcon(R.drawable.ic_food)

                }
                1-> {
                    tap.text = "Drink"
                    tap.setIcon(R.drawable.ic_drink)
                }

                    2->{
                        tap.text="Dessert"
                        tap.setIcon(R.drawable.ic_dessert)

                    }
                3->{
                        tap.text="Salat"
                        tap.setIcon(R.drawable.ic_dessert)

                    }

                else->tap.text="other"
            }
            

        }.attach()
       // tabLayout.getTabAt(0).setIcon()
       // tabLayout.setBackgroundColor(Color.BLACK)
    }
}
class Mytrans:ViewPager2.PageTransformer{
    override fun transformPage(page: View, position: Float) {
        page.apply {




        }
    }
}