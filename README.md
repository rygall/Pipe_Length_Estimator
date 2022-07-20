# pipinghandcalcs


Current Features:

- Pipe Length and Fittings Estimator

    Typically when doing a pressure drop calculation, the pressure drop is being estimated for a system that isnt actually built, and a typical procedure is to take a
    preliminary length measured off of a plan view or diagram and then estimate the real length of piping, the standard 90 degree elbows, and the standard 45 degree
    elbows that will be in the estimated length of pipe. The estimation made is to add 25% more length of the preliminary length measured and then one standard 90 degree 
    elbow and one standard 45 degree elbow for every 8 feet of estimated pipe.
  
- Pressure Drop Calculations

    The pressure drop calculation through a section of pipe is by far the most common calculation I do while designing piping systems. This feature will take the input 
    of everything needed in order to do a pressure drop calculations through a piping system and output a pressure drop (psi) along with some other useful variables. 
    This calculation uses the Churchill Equation to calculate the friction factor.
    
- Head to PSI & PSI to Head Conversion

    Converts head (ft) to pressure (psi) and vice versa for common shipboard fluids. Useful when dealing with pumps.
    
    
Future Features:
  
- Unit Conversion for the Following Metrics:
  - Length
  - Temperature
  - Weight
  - Area
  - Volume
  - Pressure
  - Density
  - Volumetric Flowrate

- Net Positive Suction Head Available (NPSHa) Calculation

- Minimum Pipe Wall Thickness Calculation

- Provide a functionality to input the temperature of fluid in the system for all calculations in order to more accurately determine the properties of the system fluid.

- Pipe Sizing Based Off Fluid Velocity Limit and Flowrate

- Fluid Velocity Calculation Based off Flowate and Pipe Size


Future GUI Features:

- For the Unit Conversion, add an action listener for the Metric JComboBox to update the input/output JComboBoxes to be the appropriate units based on the metric (i.e. if length is selected as the metric, update the input/output JComboBoxes to be feet, meters, inches, millimeters, etc.).




