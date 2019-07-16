package com.example.binish.geezerapp;

import android.animation.ObjectAnimator;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binish.geezerapp.adapters.PropertyViewAdapter;
import com.example.binish.geezerapp.models.AdvanceSearchBody;
import com.example.binish.geezerapp.models.Parameters;
import com.example.binish.geezerapp.models.PriceRange;
import com.example.binish.geezerapp.models.Property;
import com.example.binish.geezerapp.models.Result;
import com.example.binish.geezerapp.models.SearchBody;
import com.example.binish.geezerapp.utils.Utils;
import com.example.binish.geezerapp.viewmodel.GetData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    static int checkbox_id = 8000;

    String TAG = "ParameterRetrofit";
    GetData dataViewModel;
    RecyclerView recyclerView;
    LinearLayout advanceSearchLayout,searchLinearLayout;
    ConstraintLayout mainContraintLayout;
    ImageView searchDropdown;
    CardView searchCardView;
    EditText searchBox;
    CardView orderByCardView;
    NumberPicker numberPicker;
    Spinner streetSpinner, priceRangeSpinner, bedroomSpinner, bathroomSpinner, typeSpinner, furnishingSpinner;
    Spinner transportSpinner;
    Button facilityButton;
    Animation slide;

    Parameters parameters;
    ArrayList<String> facilityList = new ArrayList<>();
    PropertyViewAdapter propertyViewAdapter;
    String order_by = "price_asc";
    int defaultOrderValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        parameters = new Parameters();
        slide = AnimationUtils.loadAnimation(this,R.anim.slide);

        dataViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(GetData.class);
        dataViewModel.getParameters().observe(this, new Observer<Parameters>() {
            @Override
            public void onChanged(@Nullable Parameters parameters) {
                if (parameters.getStreets() != null)
                    populateSearch(parameters);
                MainActivity.this.parameters = parameters;
            }
        });
        searchDropdown.setOnClickListener(this);
        searchBox.setOnEditorActionListener(this);
        orderByCardView.setOnClickListener(this);
        facilityButton.setOnClickListener(this);

    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.searchDropdown:
                if (advanceSearchLayout.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(mainContraintLayout,new AutoTransition().setDuration(500));
                    advanceSearchLayout.setVisibility(View.GONE);
                    searchDropdown.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(mainContraintLayout,new AutoTransition().setDuration(500));
                    advanceSearchLayout.setVisibility(View.VISIBLE);
                    searchDropdown.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                }
                break;

            case R.id.orderByCardView:
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_order_by, null);
                AlertDialog.Builder box = new AlertDialog.Builder(this)
                        .setTitle("Order By:")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                numberPicker = dialogView.findViewById(R.id.orderByPicker);
                final String[] list = {"Price Ascending", "Price Descending", "Size Ascending", "Size Descending"};
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(list.length - 1);
                numberPicker.setDisplayedValues(list);
                numberPicker.setValue(defaultOrderValue);
                box.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (list[numberPicker.getValue()]) {
                            case "Price Ascending":
                                order_by = "price_asc";
                                defaultOrderValue = 0;
                                break;
                            case "Price Descending":
                                order_by = "price_desc";
                                defaultOrderValue = 1;
                                break;
                            case "Size Descending":
                                order_by = "size_desc";
                                defaultOrderValue = 3;
                                break;
                            case "Size Ascending":
                                order_by = "size_asc";
                                defaultOrderValue = 2;
                                break;
                        }

                        searchWork(false);
                    }
                });
                box.setView(dialogView);
                box.show();
                break;

            case R.id.facilityButton:
                View facilityView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_facilities, null);
                LinearLayout facilityLayout = facilityView.findViewById(R.id.facilityLayout);
                for (final String facility : parameters.getFacilities()
                        ) {
                    CheckBox checkBox = new CheckBox(MainActivity.this);
                    checkBox.setText(facility);

                    if (facilityList.size() != 0)
                        for (String value : facilityList
                                ) {
                            if (value.equals(facility))
                                checkBox.setChecked(true);
                        }

                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b) {
                                facilityList.add(facility);
                            } else {
                                facilityList.remove(facility);
                            }
                        }
                    });

                    facilityLayout.addView(checkBox);
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Select Facilities")
                        .setView(facilityView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Button select = (Button) view;
                                select.setText("Selected");
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE) {
            if (!searchBox.getText().toString().equals("")) {
                searchWork(true);

            } else
                Toast.makeText(MainActivity.this, "Search field cannot be empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void initRecyclerView(ArrayList<Property> properties) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        propertyViewAdapter = new PropertyViewAdapter(MainActivity.this, properties);
        recyclerView.setAdapter(propertyViewAdapter);

    }

    private void searchWork(final boolean enter) {
        if (advanceSearchLayout.getVisibility() == View.GONE) {
            String keyword = searchBox.getText().toString();
            SearchBody searchBody = new SearchBody();
            searchBody.setKeyword(keyword);
            searchBody.setSkip(0);
            searchBody.setSort_by(order_by);
            dataViewModel.setProperty(searchBody);
            observingProperties(enter);
        } else if (!facilityButton.getText().toString().equals("Select")) {
            advanceSearchLayout.setVisibility(View.GONE);
            ArrayList<String> num_bedrooms = new ArrayList<>();
            num_bedrooms.add(bedroomSpinner.getSelectedItem().toString());
            ArrayList<String> num_bathrooms = new ArrayList<>();
            num_bathrooms.add(bathroomSpinner.getSelectedItem().toString());
            String keyword = searchBox.getText().toString();
            AdvanceSearchBody advanceSearchBody = new AdvanceSearchBody();
            advanceSearchBody.setKeyword(keyword);
            advanceSearchBody.setSkip(0);
            advanceSearchBody.setSort_by(order_by);
            advanceSearchBody.setLocation(streetSpinner.getSelectedItem().toString());

            String[] lowHigh = Utils.getLowHighPrice(priceRangeSpinner.getSelectedItem().toString());
            advanceSearchBody.setPrice_low(Integer.valueOf(lowHigh[0]));
            advanceSearchBody.setPrice_high(Integer.valueOf(lowHigh[2]));

            advanceSearchBody.setNum_bedrooms(num_bedrooms);
            advanceSearchBody.setNum_bathrooms(num_bathrooms);
            advanceSearchBody.setType(typeSpinner.getSelectedItem().toString());
            advanceSearchBody.setFurnishing(furnishingSpinner.getSelectedItem().toString());
            advanceSearchBody.setFacilities(facilityList);
            advanceSearchBody.setTransport(transportSpinner.getSelectedItem().toString());
            dataViewModel.setPropertyAdvance(advanceSearchBody);
            observingProperties(enter);
        } else {
            Toast.makeText(MainActivity.this, "Please select atleast one facility", Toast.LENGTH_SHORT).show();
        }
    }

    private void observingProperties(final Boolean enter) {
        dataViewModel.getProperty().observe(this, new Observer<Result>() {
            @Override
            public void onChanged(@Nullable Result result) {
                if (enter)
                    initRecyclerView(result.getProperties());
                else
                    propertyViewAdapter.notifyDataSetChanged();
                orderByCardView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void populateSearch(Parameters parameters) {
        //Streets
        addValueToSpinner(R.id.streetSpinner, parameters.getStreets());

        //Price Range
        addValueToPriceRange(R.id.priceRangeSpinner, parameters.getPrice_ranges());
        //Number of Bedrooms
        addValueToSpinner(R.id.bedroomSpinner, parameters.getNum_bedrooms());
        //Number of Bathrooms
        addValueToSpinner(R.id.bathroomSpinner, parameters.getNum_bathrooms());
        //Types
        addValueToSpinner(R.id.typeSpinner, parameters.getTypes());
        //Furnishing
        addValueToSpinner(R.id.furnishingSpinner, parameters.getFurnishing());
        //Facilities

        //Transport
        addValueToSpinner(R.id.transportSpinner, parameters.getTransport());
        //Popular Keywords

    }

    private void addValueToSpinner(int spinnerID, List<String> items) {
        Spinner streetSpinner = findViewById(spinnerID);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        try {
            streetSpinner.setAdapter(adapter);
        } catch (NullPointerException e) {
            Log.i(TAG, "Null Pointer: " + e);
        }
    }

    private void addValueToPriceRange(int spinnerID, List<PriceRange> prices) {
        ArrayList<String> items = new ArrayList<>();
        try {
            for (PriceRange price : prices
                    ) {
                items.add(price.getLow() + " - " + price.getHigh());
            }
            Spinner streetSpinner = findViewById(spinnerID);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
            streetSpinner.setAdapter(adapter);
        } catch (NullPointerException e) {
            Log.i(TAG, "Null Pointer: " + e);
        }
    }

    private void initializeViews() {
        searchCardView = findViewById(R.id.searchCardView);
        mainContraintLayout = findViewById(R.id.mainContraintLayout);
        advanceSearchLayout = findViewById(R.id.advanceSearchLayout);
        searchLinearLayout = findViewById(R.id.searchLinearLayout);
        searchDropdown = findViewById(R.id.searchDropdown);
        searchBox = findViewById(R.id.searchBox);
        orderByCardView = findViewById(R.id.orderByCardView);

        recyclerView = findViewById(R.id.recyclerView);
        facilityButton = findViewById(R.id.facilityButton);
        streetSpinner = findViewById(R.id.streetSpinner);
        priceRangeSpinner = findViewById(R.id.priceRangeSpinner);
        bedroomSpinner = findViewById(R.id.bedroomSpinner);
        bathroomSpinner = findViewById(R.id.bathroomSpinner);
        typeSpinner = findViewById(R.id.typeSpinner);
        furnishingSpinner = findViewById(R.id.furnishingSpinner);
        transportSpinner = findViewById(R.id.transportSpinner);
    }

}
