/*
 * Cloud9: A MapReduce Library for Hadoop
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package edu.umd.cloud9.util.fd;

import edu.umd.cloud9.util.SortableEntries;
import edu.umd.cloud9.util.pair.PairOfObjectInt;

/**
 * A frequency distribution where events are arbitrary objects and counts are ints.
 *
 * @author Jimmy Lin
 *
 */
public interface Object2IntFrequencyDistribution<K extends Comparable<K>>
    extends SortableEntries<PairOfObjectInt<K>> {

	/**
	 * Increments the count of an event <code>key</code>.
	 */
	public void increment(K key);

	/**
	 * Increments the count of an event <code>key</code> by <code>cnt</code>.
	 */
	public void increment(K key, int cnt);

	/**
	 * Decrements the count of an event <code>key</code>.
	 */
	public void decrement(K key);

	/**
	 * Decrements the count of a particular event <code>key</code> by <code>cnt</code>.
	 */
	public void decrement(K key, int cnt);

	/**
	 * Returns true if <i>key</i> exists in this object.
	 */
	public boolean contains(K key);

	/**
	 * Returns the count of a particular event <i>key</i>.
	 */
	public int get(K key);

  /**
   * Returns the frequency of a particular event <i>key</i>.
   */
  public float getFrequency(K key);

  /**
   * Returns the log frequency of a particular event <i>key</i>.
   */
  public float getLogFrequency(K key);

	/**
	 * Sets the count of a particular event <i>key</i> to <code>cnt</code>.
	 */
	public int set(K key, int cnt);

	/**
	 * Removes the count of a particular event <code>key</code>.
	 */
	public int remove(K k);

	/**
	 * Removes all events.
	 */
	public void clear();

	/**
	 * Returns number of distinct events observed. Note that if an event is
	 * observed and then its count subsequently removed, the event will not be
	 * included in this count.
	 */
	public int getNumberOfEvents();

	/**
	 * Returns the sum of counts of all observed events.
	 */
	public long getSumOfCounts();
}
