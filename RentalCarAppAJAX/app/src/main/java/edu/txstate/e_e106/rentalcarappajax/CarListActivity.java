package edu.txstate.e_e106.rentalcarappajax;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class CarListActivity extends ListActivity {

    List<RentalCar> rentalCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCars();
    }
    protected void getCars(){

    }
}
