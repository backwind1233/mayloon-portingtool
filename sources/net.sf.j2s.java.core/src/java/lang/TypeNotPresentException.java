/* Copyright 2006 The Apache Software Foundation or its licensors, as applicable
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.lang;

/**
 * <p>
 * Indicates that a class, interface, enum or annotation type cannot be found.
 * This exception is an unchecked alternative to
 * {@link java.lang.ClassNotFoundException}.
 * </p>
 * 
 * @since 1.5
 * @author Nathan Beyer (Harmony)
 */
public class TypeNotPresentException extends RuntimeException {
	private static final long serialVersionUID = -5101214195716534496L;

    private String typeName;

    /**
     * <p>
     * Constructs an instance will a fully qualified type name and an optional
     * cause.
     * </p>
     * 
     * @param typeName The fully qualified type name.
     * @param cause The <code>Throwable</code> that caused this exception or
     *        <code>null</code>.
     */
    public TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        this.typeName = typeName;
    }

    /**
     * <p>
     * The fully qualified type name.
     * </p>
     * 
     * @return A String instance.
     */
    public String typeName() {
        return typeName;
    }
}
