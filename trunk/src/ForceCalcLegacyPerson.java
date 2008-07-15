/**
 * Copyright 2008 code_swarm project team
 *
 * This file is part of code_swarm.
 *
 * code_swarm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * code_swarm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with code_swarm.  If not, see <http://www.gnu.org/licenses/>.
 */


/**
 * @brief Legacy force calculation between persons.
 */
public class ForceCalcLegacyPerson extends ForceCalc
{
  final private double randMultiplier;
  
  /**
   * Constructor for initializing parameters.
   */
  ForceCalcLegacyPerson(double paramMultiplier)
  {
	  randMultiplier = paramMultiplier;
  }
  
  /**
   * Legacy method that calculate the force between to Person nodes.
   * 
   * @param[in] NodeA
   * @param[in] NodeB
   * @param[out] force
   * 
   * @return a forceVector representing the force between to nodes
   */
  public void calculateForceBetween( code_swarm.Node NodeA, code_swarm.Node NodeB, ForceVector force )
  {
    float distx, disty;
    float lensq;
    
    /** @todo comment this algorithm */
    distx = NodeA.x - NodeB.getX();
    disty = NodeA.y - NodeB.getY();
    lensq = distx * distx + disty * disty;
    if (lensq == 0) {
      force.set( Math.random()*randMultiplier, Math.random()*randMultiplier );
    } else if (lensq < 10000) {
      force.set( distx / lensq, disty / lensq );
    }
  }
}

