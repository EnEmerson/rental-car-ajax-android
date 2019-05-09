package edu.txstate.e_e106.rentalcarappajax;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CarDetailsActivity extends AppCompatActivity {

    private String carBrand, carColor, carName;
    private int carId;
    private float carRent;
    private int carPosition;
    public DecimalFormat dollars = new DecimalFormat("$###,###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        carBrand = sharedPref2.getString("brand", "No brand found.");
        carColor = sharedPref2.getString("color", "No color found.");
        carName = sharedPref2.getString("name", "No name found.");
        carId = sharedPref2.getInt("id", 0);
        carRent = sharedPref2.getFloat("rent", 0);
        carPosition = sharedPref2.getInt("pos", 0);
        final TextView totalDisplay = findViewById(R.id.totalCostDisplay);
        final EditText rentDaysText = findViewById(R.id.editRentalDays);

        Button calcCost = findViewById(R.id.calcButton);
        calcCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numRentDays = Integer.parseInt(rentDaysText.getText().toString());
                if(numRentDays > 30){
                    totalDisplay.setText("Please call our representatives at: (512)777-2222");
                    Toast.makeText(CarDetailsActivity.this, "Number of rental days too large, please call representatives.", Toast.LENGTH_LONG).show();
                }
                else{
                    float totalCost = numRentDays * carRent;
                    totalDisplay.setText("Total Cost: " + dollars.format(totalCost));
                }
            }
        });

        Button updateButton = findViewById(R.id.updateRentButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarDetailsActivity.this, UpdateRentActivity.class));
            }
        });
    }
}
