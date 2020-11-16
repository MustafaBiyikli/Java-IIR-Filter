public class MainActivity {
    private IIR_Filter iir_filter = null;
    private List<List<Float>> IIR_coefficients = Arrays.asList(
        "....",
        "....",
        "your coeffs"
    )

    public void yourDataSamplerFunction(float inputData) {
        float filteredData = iir_filter.doFilter(inputData);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iir_filter = new IIR_Filter();
        iir_filter.set_coefficients(IIR_coefficients);
    }
}