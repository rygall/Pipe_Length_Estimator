# pipinghandcalcs

Summary:

I am developing this program while I work as a mechanical engineer designing piping systems. I do a lot of day to day calculations that are a bit repititive, so I 
figured why not just develop some software to provide an easy to use GUI where all of my calculations can be done in one place rather than having to jump around 
between different documents and software.



Current Features:

- Pipe Length and Fittings Estimator

    Typically when doing a pressure drop calculation, the pressure drop is being estimated for a system that isnt actually built, and a typical procedure is to take a
    preliminary length, add 25% to that length, and then estimate the standard 90 degree elbows and standard 45 degree elbows that will be in the estimated length of 
    pipe. The estimaion is one standard 90 degree elbow and one standard 45 degree elbow for every 8 feet of estimated pipe.
  
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

- Provide a functionality to input the temperature of fluid in the system for all calculations in order to more accurately calculation the properties of the fluid.


Future GUI Features:

- A console to display all results from calculations

- Have one popup window to provide all required input for a calcaulation rather than a bunch of different seperate popup windows




